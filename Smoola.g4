grammar Smoola;

    program
    :
        main = mainClass ( mainDec = classDeclaration)* EOF
    ;
    mainClass returns [ClassDeclaration synMainClass]
    :
        // name should be checked later
        'class'  mainClassName = ID '{' 'def' mainMethodName = ID '(' ')' ':' 'int' '{'  allStatements = statements 'return' mainVal = expression ';' '}' '}'
        {
            $synMainClass = AstMaker.mainClass($mainClassName.text, $mainMethodName.text, $mainVal.synExpression, $allStatements.synStatements);
        }
    ;
    classDeclaration returns [ClassDeclaration synClassDeclaration]
    :
        'class' name = ID ('extends' parentName = ID)?
        {
           $synClassDeclaration = AstMaker.classDeclaration($name.text, $parentName.text);
        }
        '{'
        (varDec = varDeclaration {$synClassDeclaration.addVarDeclaration($varDec.synVarDec)} )*
        (methodDec = methodDeclaration {$synClassDeclaration.addMethodDeclaration($methodDec.synMethodDeclaration})*
        '}'

    ;
    varDeclaration returns [VarDeclaration synVarDec]
    :
        'var' varName = ID ':' varType = type ';'
        {
            $synVarDec = AstMaker.varDeclaration(new Identifier($varName.text), $varType.synType);
        }
    ;
    methodDeclaration returns [MethodDeclaration synMethodDeclaration]
    :
        'def' methodName = ID
        {
            $synMethodDeclaration = new MethodDeclaration(new Identifier($methodName.text));
        }
        ('(' ')' | ('(' arg1Id = ID ':' arg1Type = type
        {
            $synMethodDeclaration.addArg(new VarDeclaration(new Identifier($arg1Id.text), $arg1Type.synType));
        }
        (',' argId = ID ':' argType = type
        {
            $synMethodDeclaration.addArg(new VarDeclaration(new Identifier($argId.text), $argType.synType));
        }
        )* ')')) ':' returnType = type
        {
            $synMethodDeclaration.setReturnType($returnType.synType);
        }
        '{'  (newVar = varDeclaration
        {
            $synMethodDeclaration.addLocalVar($newVar.synVarDec);
        }
        )* allStatements = statements
        {
            $synMethodDeclaration.setBody($allStatements.synStatements);
        }
        'return' returnVal = expression
        {
            $synMethodDeclaration.setReturnValue($returnVal.synExpression);
        }
        ';' '}'
    ;
    statements returns [ArrayList<Statement> synStatements]
    :
        {
            $synStatements = new ArrayList<>(); ;
        }
        (newStatement = statement
        {
            $synStatements.add($newStatement.synStatement);
        }
        )*
    ;
    statement returns [Statement synStatement]
    :
        stmB = statementBlock {$synStatement = $stmB.synStatementBlock} |
        stmC = statementCondition {$synStatement = $stmC.synStatementCondition} |
        stmL = statementLoop {$synStatement = $stmL.synStatementLoop} |
        stmW = statementWrite {$synStatement = $stmW.synStatementWrite} |
        stmA = statementAssignment {$synStatement = $stmA.synStatementAssign}
    ;
    statementBlock returns [Statement synStatementBlock]
    :
        '{'  allStatements = statements {$synStatementBlock.setBody($allStatements.synStatements)} '}'
    ;
    statementCondition returns [Statement synStatementCondition]
    :
        'if' '(' conditionExp = expression')' 'then' consequenceBody = statement
         {
            $synStatementCondition = new Conditional($conditionExp.synExpression, $consequenceBody.synStatement);
         }('else' altBody = statement
         {
            $synStatementCondition.setAlternativeBody($altBody.synStatement);
         }
         )?
    ;
    statementLoop returns [Statement synStatementLoop]
    :
        'while' '(' loopCondition = expression ')' loopBody = statement
        {
            $synStatementLoop = new While($loopCondition.synExpression, $loopBody.synStatement);
        }
    ;
    statementWrite returns [Statement synStatementWrite]
    :
        'writeln(' arg = expression ')' ';'
        {
            $synStatementWrite = new Write($arg.synExpression);
        }
    ;
    statementAssignment returns [Statement synStatementAssign]
    :
        assignExpr = expression ';'
        {
            $synStatementAssign = new Assign($assignExpr.synExpression.getLeft(), $assignExpr.synExpression.getRight());
        }
    ;
    expression returns [Expression synExpression]
    :
        expr = expressionAssignment
        {
            $synExpression = $expr.synExpression;
        }
    ;
    expressionAssignment returns [Expression synExpression]
    :
        lExpr = expressionOr '=' rExpr = expressionAssignment
        {
            $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.assign);

        }
        |	expr = expressionOr
        {
            $synExpression = $expr.synExpression;
        }
    ;
    expressionOr returns [Expression synExpression]
    :
        lExpr = expressionAnd rExpr = expressionOrTemp
        {
            if(rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.or);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionOrTemp returns [Expression synExpression]
    :
        '||' lExpr = expressionAnd rExpr = expressionOrTemp
        {
            if($rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.or);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionAnd returns [Expression synExpression]
    :
        lExpr = expressionEq rExpr = expressionAndTemp
        {
            if($rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.and);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionAndTemp returns [Expression synExpression]
    :
        '&&' lExpr = expressionEq rExpr = expressionAndTemp
        {
            if($rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.and);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionEq returns [Expression synExpression]
    :
        lExpr = expressionCmp rExpr = expressionEqTemp
        {
            if($rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.eq);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionEqTemp returns [Expression synExpression]
    :
        ('==' | '<>') lExpr = expressionCmp rExpr = expressionEqTemp
        {
            if($rExpr.synExpression != null)
                $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.eq);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionCmp returns [Expression synExpression]
    :
        lExpr =  expressionAdd rExpr = expressionCmpTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.lt)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.lt);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.gt);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionCmpTemp returns [Expression synExpression]
    :
        ('<' | '>') lExpr = expressionAdd rExpr = expressionCmpTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.lt)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.lt);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.gt);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionAdd returns [Expression synExpression]
    :
        lExpr = expressionMult rExpr = expressionAddTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.add)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.add);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.sub);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionAddTemp returns [Expression synExpression]
    :
        ('+' | '-') lExpr = expressionMult rExpr = expressionAddTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.add)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.add);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.sub);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionMult returns [Expression synExpression]
    :
        lExpr = expressionUnary rExpr = expressionMultTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.mult)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.mult);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.div);
            else
                $synExpression = $lExpr.synExpression;
        }
    ;
    expressionMultTemp returns [Expression synExpression]
    :
        ('*' | '/') lExpr = expressionUnary rExpr = expressionMultTemp
        {
            if($rExpr.synExpression != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.mult)
                    $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.mult);
                else
                     $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.div);
            else
                $synExpression = $lExpr.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionUnary returns [Expression synExpression]
    :
        '!' uExpr1 = expressionUnary
        {
            $synExpression = new UnaryExpression(UnaryOperator.not, $uExpr1.synExpression);
        }
        | '-' uExpr2 = expressionUnary
        {
            $synExpression = new UnaryExpression(UnaryOperator.minus, $uExpr2.synExpression);
        }
        |	expr = expressionMem
        {
            $synExpression = $expr.synExpression;
        }
    ;
    expressionMem returns [Expression synExpression]
    :
        instance = expressionMethods index = expressionMemTemp
        {
            if($index.synExpression != null)
                $synExpression = new ArrayCall($instance.synExpression, $index.synExpression);
            else
                $synExpression = $instance.synExpression;
        }
    ;
    expressionMemTemp returns [Expression synExpression]
    :
        '[' index = expression ']'
        {
            $synExpression = $index.synExpression;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionMethods returns [Expression synExpression]
    :
        inhInstance = expressionOther method = expressionMethodsTemp[inhInstance]
        {
            if($method.synExpression != null)
                $synExpression = $method.synExpression;
            else
                $synExpression = $inhInstance.synExpression;
        }
    ;
    expressionMethodsTemp[$inhExpression] returns [Expression synExpression]
    :
        '.'
        {
            Expression method;
        }
        (methodName = ID '(' ')'
        {
            method = new MethodCall($inhExpression.synExpression, new Identifier($methodName.text));
        }
        | methodName = ID '(' ( arg1 = expression
        {
            method = new MethodCall($inhExpression.synExpression, new Identifier($methodName.text));
            method.addArg($arg1.synExpression);
        }
        (',' arg = expression {method.addArg($arg.synExpression)})*) ')'
        | 'length'
        {
            method = new Length($inhExpression.synExpression);
        }
        ) expr = expressionMethodsTemp[method]
        {
            if(expr.synExpression != null)
                $synExpression = $expr.synExpression;
            else
                $synExpression = method;
        }
        |
        {
            $synExpression = null;
        }
    ;
    expressionOther returns [Expression synExpression]
    :
    val = CONST_NUM {$synExpression = new IntValue($val.int, new IntType());}
          |   val = CONST_STR {$synExpression = new StringValue($val.text, new StringType());}
          |   'new ' 'int' '[' val = CONST_NUM ']' {$synExpression = new NewArray(); $synExpression.setExpression(new IntValue($val.int, new IntType()));}
          |   'new ' className = ID '(' ')' {$synExpression = new NewClass(new Identifier($className.text));}
          |   'this' {$synExpression = new This();}
          |   'true' {$synExpression = new BooleanValue(true, new BooleanType());}
          |   'false' {$synExpression = new BooleanValue(false, new BooleanType());}
          |   val = ID {$synExpression = new Identifier($val.text);}
          |   val = ID '[' ex = expression ']' {$synExpression = new ArrayCall();}
          |   '(' ex = expression ')' {$synExpression = $ex.synExpression;}
    ;
    type returns [Type synType]
    :
        'int' {$synType = new IntType();} |
        'boolean' {$synType = new BooleanType();} |
        'string' {$synType = new StringType();} |
        'int' '[' ']' {$synType = new ArrayType();} |
        ID {$synType = new UserDefinedType();}
    ;
    CONST_NUM:
        [0-9]+
    ;

    CONST_STR:
        '"' ~('\r' | '\n' | '"')* '"'
    ;
    NL:
        '\r'? '\n' -> skip
    ;

    ID:
        [a-zA-Z_][a-zA-Z0-9_]*
    ;

    COMMENT:
        '#'(~[\r\n])* -> skip
    ;

    WS:
        [ \t] -> skip
    ;