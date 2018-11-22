grammar Smoola;

   program:
        mainClass
        (classDeclaration)*
        EOF 
    ;
    mainClass returns [ClassDeclaration synMainClass]
    :
        // name should be checked later
        'class'  mainClassName = ID '{' 'def' mainMethodName = ID '(' ')' ':' 'int' '{'  allStatements = statements 'return' mainVal = expression ';' '}' '}'
        {

            $synMainClass = AstMaker.mainClass($mainClassName, $mainMethodName, $mainVal, $allStatements);

        }
    ;
    classDeclaration returns [ClassDeclaration synClassDeclaration]
    :
        'class' name = ID ('extends' parrentName = ID)?
         {
            $synClassDeclaration = AstMaker.classDeclaration($name, $parrentName);
            
         }
         '{'
         (varDec = varDeclaration {$synClassDeclaration.addVarDeclaration(varDec)} )*
         (methodDec = methodDeclaration {$synClassDeclaration.addMethodDeclaration(methodDec})*
         '}'

    ;
    varDeclaration:
        'var' ID ':' type ';'
    ;
    methodDeclaration returns [MethodDeclaration synMethodDeclaration]:
        'def' methodName = ID
        {
            $synMethodDeclaration = new MethodDeclaration(methodName);
        }
        ('(' ')' | ('(' arg1Id = ID ':' arg1Type = type
        {
            $synMethodDeclaration.addArg(new VarDeclaration(arg1Id, arg1Type));
        }
        (',' argId = ID ':' argType = type
        {
            $synMethodDeclaration.addArg(new VarDeclaration(argId, argType));
        }
        )* ')')) ':' returnType = type
        {
            $synMethodDeclaration.setReturnType(returnType);
        }
        '{'  (newVar = varDeclaration
        {
            $synMethodDeclaration.addLocalVar(newVar);
        }
        )* allStatements = statements
        {
            $synMethodDeclaration.setBody(allStatements);
        }
        'return' returnVal = expression
        {
            $synMethodDeclaration.setReturnValue(returnVal);
        }
        ';' '}'
    ;
    statements returns [ArrayList<Statement> synStatements]
    :
        {
            $synStatements = new ArrayList<>(); ;
        }
        (newStatements = statement
        {
            $synStatements.add(newStatements);
        }
        )*
    ;
    statement returns [Statement synStatement]
    :
        stmB = statementBlock {$synStatement = $stmB.synStatementBlock} |
        stmC = statementCondition {$synStatement = $stmC.synStatementCondition} |
        stmL = statementLoop {$synStatement = $stmL} |
        stmW = statementWrite {$synStatement = $stmW} |
        stmA = statementAssignment {$synStatement = $stmA}
    ;
    statementBlock returns [Statement synStatementBlock]
    :
        '{'  allStatements = statements {$synStatementBlock.setBody(allStatements)} '}'
    ;
    statementCondition returns [Statement synStatementCondition]
    :
        'if' '(' conditionExp = expression')' 'then' consequenceBody = statement
         {
            $synStatementCondition = new Conditional($conditionExp , $consequenceBody.synStatement);
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
            $synStatementLoop = new While($loopCondition, $loopBody.synStatement);
        }
    ;
    statementWrite returns [Statement synStatementWrite]:
        'writeln(' arg = expression ')' ';'
        {
            $synStatementWrite = new Write($arg);
        }
    ;
    statementAssignment returns [Statement synStatementAssign]
    :
        assignExpr = expression ';'
        {
            $synStatementAssign = new Assign(assignExpr..getLeft(), assignExpr..getRight());
        }
    ;

    expression returns [Expression synExpression]
    :
		expr = expressionAssignment
		{
		    $synExpression = $expr;
		}
	;

    expressionAssignment returns [Expression synExpression]
    :
		lExpr = expressionOr '=' rExpr = expressionAssignment
		{
		    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.assign);

		}
	    |	expr = expressionOr
	    {
	        $synExpression = $expr;
	    }
	;

    expressionOr returns [Expression synExpression]
    :
		lExpr = expressionAnd rExpr = expressionOrTemp
		{
		    if(rExpr != null)
		        $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.or);
		    else
		        $synExpression = $lExpr;
		}
	;

    expressionOrTemp returns [Expression synExpression]
    :
		'||' lExpr = expressionAnd rExpr = expressionOrTemp
		{
		    if($rExpr != null)
                $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.or);
            else
                $synExpression = $lExpr;
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
            if($rExpr != null)
                $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.and);
            else
                $synExpression = $lExpr;
        }
	;

    expressionAndTemp returns [Expression synExpression]
    :
		'&&' lExpr = expressionEq rExpr = expressionAndTemp
		{
            if($rExpr != null)
                $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.and);
            else
                $synExpression = $lExpr;
        }
	    |
	    {
	        $synExpression = null ;
	    }
	;

    expressionEq returns [Expression synExpression]
    :
		lExpr = expressionCmp rExpr = expressionEqTemp
		{
            if($rExpr != null)
                $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.eq);
            else
                $synExpression = $lExpr;
        }
	;

    expressionEqTemp returns [Expression synExpression]
    :
		('==' | '<>') lExpr = expressionCmp rExpr = expressionEqTemp
		{
            if($rExpr != null)
                $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.eq);
            else
                $synExpression = $lExpr;
        }
	    |
	    {
	        $synExpression = null;
	    }
	;

    expressionCmp returns [Expression synExpression]:
		lExpr =  expressionAdd rExpr = expressionCmpTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.lt)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.lt);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.gt);
            else
                $synExpression = $lExpr;
        }
	;

    expressionCmpTemp returns [Expression synExpression]:
		('<' | '>') lExpr = expressionAdd rExpr = expressionCmpTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.lt)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.lt);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.gt);
            else
                $synExpression = $lExpr;
        }
	    |
        {
            $synExpression = null;
        }
	;

    expressionAdd returns [Expression synExpression]:
		lExpr = expressionMult rExpr = expressionAddTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.add)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.add);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.sub);
            else
                $synExpression = $lExpr;
        }
	;

    expressionAddTemp returns [Expression synExpression]:
		('+' | '-') lExpr = expressionMult rExpr = expressionAddTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.add)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.add);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.sub);
            else
                $synExpression = $lExpr;
        }
	    |
        {
            $synExpression = null;
        }
	;

    expressionMult returns [Expression synExpression] :
		lExpr = expressionUnary rExpr = expressionMultTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.mult)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.mult);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.div);
            else
                $synExpression = $lExpr;
        }
	;

    expressionMultTemp:
		('*' | '/') lExpr = expressionUnary rExpr = expressionMultTemp
        {
            if($rExpr != null)
                if($rExpr.synExpression.getBinaryOperator() == BinaryOperator.mult)
                    $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.mult);
                else
                     $synExpression = new BinaryExpression($lExpr, $rExpr, BinaryOperator.div);
            else
                $synExpression = $lExpr;
        }
	    |
        {
            $synExpression = null;
        }
	;

    expressionUnary returns [Expression synExpression]:
		'!' uExpr1 = expressionUnary 
        {
            $synExpression = new UnaryExpression(UnaryOperator.not, $uExpr1);
        }
        | '-' uExpr2 = expressionUnary
        {
            $synExpression = new UnaryExpression(UnaryOperator.minus, $uExpr2);
        }
	    |	expr = expressionMem
        {
            $synExpression = $expr;
        }
	;

    expressionMem:
		expressionMethods expressionMemTemp
	;

    expressionMemTemp:
		'[' expression ']'
	    |
	;
	expressionMethods:
	    expressionOther expressionMethodsTemp
	;
	expressionMethodsTemp:
	    '.' (ID '(' ')' | ID '(' (expression (',' expression)*) ')' | 'length') expressionMethodsTemp
	    |
	;
    expressionOther returns [Expression expr]:
    val = CONST_NUM {$expr = new IntValue($val.int, new IntType());}
          | val = CONST_STR {$expr = new StringValue($val.text, new StringType());}
          |   'new ' 'int' '[' val = CONST_NUM ']' {$expr = new NewArray(); $expr.setExpression(new IntValue($val.int, new IntType()));} //TODO
          |   'new ' clasName = ID '(' ')' {$epxr = new NewClass(new Identifier($className.text));}
          |   'this' {$expr = new This();}
          |   'true' {$expr = new BooleanValue(true, new BooleanType());}
          |   'false' {$expr = new BooleanValue(false, new BooleanType());}
          | val = ID //TODO
          |   val = ID '[' ex = expression ']' {$expr = new ArrayCall();}
          | '(' ex = expression ')'
     ;
	type:
	    'int' |
	    'boolean' |
	    'string' |
	    'int' '[' ']' |
	    ID
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