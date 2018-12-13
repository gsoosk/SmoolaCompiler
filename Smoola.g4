grammar Smoola;

@header {
import main.Tools.AstMaker;
import main.ast.node.*;
import main.ast.*;
import main.ast.node.expression.*;
import main.ast.node.expression.Value.*;
import main.ast.node.statement.*;
import main.ast.node.declaration.*;
import main.ast.Type.*;
import main.ast.Type.ArrayType.*;
import main.ast.Type.PrimitiveType.*;
import main.ast.Type.UserDefinedType.*;
import main.ast.node.expression.BinaryExpression.BinaryOperator;
import main.ast.node.expression.UnaryExpression.UnaryOperator;
}

    program
    :
        main = mainClass
        {
            Program program = new Program();
            program.setMainClass($main.synMainClass);
        }
        ( classDec = classDeclaration {program.addClass($classDec.synClassDeclaration);})* EOF
        {
            Visitor visitor = new VisitorImpl();
            visitor.visit(program);
        }


    ;
    mainClass returns [ClassDeclaration synMainClass]
    :
        'class'  mainClassName = ID '{' 'def' mainMethodName = ID '(' ')' ':' 'int' '{'  allStatements = statements 'return' mainVal = expression ';' '}' '}'
        {
            $synMainClass = AstMaker.mainClass($mainClassName.text, $mainMethodName.text, $mainVal.synExpression, $allStatements.synStatements);
            $synMainClass.setLineNumber($mainClassName.getLine());
        }
    ;
    classDeclaration returns [ClassDeclaration synClassDeclaration]
    :
        'class' name = ID ('extends' parentName = ID)?
        {
           $synClassDeclaration = AstMaker.classDeclaration($name.text, $parentName.text);
           $synClassDeclaration.setLineNumber($name.getLine());
        }
        '{'
        (varDec = varDeclaration {$synClassDeclaration.addVarDeclaration($varDec.synVarDec);} )*
        (methodDec = methodDeclaration {$synClassDeclaration.addMethodDeclaration($methodDec.synMethodDeclaration);})*
        '}'

    ;
    varDeclaration returns [VarDeclaration synVarDec]
    :
        var = 'var' varName = ID ':' varType = type ';'
        {
            $synVarDec = AstMaker.varDeclaration(new Identifier($varName.text), $varType.synType);
            $synVarDec.setLineNumber($var.getLine());
        }
    ;
    methodDeclaration returns [MethodDeclaration synMethodDeclaration]
    :
        'def' methodName = ID
        {

            $synMethodDeclaration = new MethodDeclaration(new Identifier($methodName.text));
            $synMethodDeclaration.setLineNumber($methodName.getLine());
        }
        ('(' ')' | ('(' arg1Id = ID ':' arg1Type = type
        {
            VarDeclaration newVarDeclaration = new VarDeclaration(new Identifier($arg1Id.text), $arg1Type.synType);
            newVarDeclaration.setLineNumber($arg1Id.getLine());
            $synMethodDeclaration.addArg(newVarDeclaration);
        }
        (',' argId = ID ':' argType = type
        {
            VarDeclaration newVarDeclaration1 = new VarDeclaration(new Identifier($argId.text), $argType.synType);
            newVarDeclaration1.setLineNumber($argId.getLine());
            $synMethodDeclaration.addArg(newVarDeclaration1);
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
        stmB = statementBlock {$synStatement = $stmB.synStatementBlock;} |
        stmC = statementCondition {$synStatement = $stmC.synStatementCondition;} |
        stmL = statementLoop {$synStatement = $stmL.synStatementLoop;} |
        stmW = statementWrite {$synStatement = $stmW.synStatementWrite;} |
        stmA = statementAssignment {$synStatement = $stmA.synStatementAssign;}
    ;
    statementBlock returns [Statement synStatementBlock]
    :
    {
        Block block = new Block();
    }
        '{'  allStatements = statements
    {
        block.setBody($allStatements.synStatements);
        $synStatementBlock = block;
    }
        '}'
    ;
    statementCondition returns [Statement synStatementCondition]
    :
         'if' '(' conditionExp = expression')' 'then' consequenceBody = statement
         {
            Conditional conditional = new Conditional($conditionExp.synExpression, $consequenceBody.synStatement);
            $synStatementCondition = conditional;
         }('else' altBody = statement
         {
            conditional.setAlternativeBody($altBody.synStatement);
            $synStatementCondition = conditional;
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
        expr = expression ';'
        {
            if($expr.BinaryOp != null)
            {
                $synStatementAssign = new Assign(((BinaryExpression)$expr.synExpression).getLeft(), ((BinaryExpression)$expr.synExpression).getRight());
            }
            else
            {
                $synStatementAssign = new Statement();
            }
        }
    ;
    //Todo : check all lines number in all rules to be correct
    expression returns [Expression synExpression, String BinaryOp]
    :
        expr = expressionAssignment
        {

            $synExpression = $expr.synExpression;
            $BinaryOp = $expr.BinaryOp;

        }
    ;
    expressionAssignment returns [Expression synExpression, String BinaryOp]
    :
        lExpr = expressionOr val = '=' rExpr = expressionAssignment
        {
            $BinaryOp = "=";
            $synExpression = new BinaryExpression($lExpr.synExpression, $rExpr.synExpression, BinaryOperator.assign);
            $synExpression.setLineNumber($val.getLine());

        }
        |	expr = expressionOr
        {
            $BinaryOp = null;
            $synExpression = $expr.synExpression;
        }
    ;
    expressionOr returns [Expression synExpression]
    :
        lExpr = expressionAnd rExpr = expressionOrTemp[$lExpr.synExpression]
        {
           $synExpression = $rExpr.synExpression;
        }
    ;
    expressionOrTemp[Expression inhExpression] returns [Expression synExpression]
    :
        val = '||' lExpr = expressionAnd
        {

               Expression expr = new BinaryExpression($inhExpression, $lExpr.synExpression , BinaryOperator.or);
               $synExpression.setLineNumber($val.getLine());
        }
        rExpr = expressionOrTemp[expr]
        {
            $synExpression = $rExpr.synExpression;
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionAnd returns [Expression synExpression]
    :
        lExpr = expressionEq rExpr = expressionAndTemp[$lExpr.synExpression]
        {
           $synExpression = $rExpr.synExpression;
        }
    ;
    expressionAndTemp[Expression inhExpression] returns [Expression synExpression]
    :
        val = '&&' lExpr = expressionEq
        {

               Expression expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.and);
        }
         rExpr = expressionAndTemp[expr]
        {

            $synExpression = $rExpr.synExpression;
            $synExpression.setLineNumber($val.getLine());
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionEq returns [Expression synExpression]
    :
        lExpr = expressionCmp rExpr = expressionEqTemp[$lExpr.synExpression]
        {
           $synExpression = $rExpr.synExpression;
        }
    ;
    expressionEqTemp[Expression inhExpression] returns [Expression synExpression]
    :
        binaryOp = ('==' | '<>') lExpr = expressionCmp
        {
            Expression expr;
             if($binaryOp.text.equals("=="))
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.eq);
            else
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.neq);

        }
        rExpr = expressionEqTemp[expr]
        {
            $synExpression = $rExpr.synExpression;
            $synExpression.setLineNumber($binaryOp.getLine());
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionCmp returns [Expression synExpression]
    :
        lExpr =  expressionAdd rExpr = expressionCmpTemp[$lExpr.synExpression]
        {
           $synExpression = $rExpr.synExpression;
        }
    ;
    expressionCmpTemp[Expression inhExpression] returns [Expression synExpression]
    :
        binaryOp = ('<' | '>') lExpr = expressionAdd
        {
            Expression expr;
            if($binaryOp.text.equals("<"))
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.lt);
            else
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.gt);

        }
        rExpr = expressionCmpTemp[expr]
        {
            $synExpression = $rExpr.synExpression;
            $synExpression.setLineNumber($binaryOp.getLine());
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionAdd returns [Expression synExpression]
    :
        lExpr = expressionMult rExpr = expressionAddTemp[$lExpr.synExpression]
        {
            $synExpression = $rExpr.synExpression;
        }
    ;
    expressionAddTemp[Expression inhExpression] returns [Expression synExpression]
    :
        binaryOp = ('+' | '-') lExpr = expressionMult
        {
            Expression expr;
            if($binaryOp.text.equals("+"))
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.add);
            else
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.sub);

        }
        rExpr = expressionAddTemp[expr]
        {
            $synExpression = $rExpr.synExpression;
            $synExpression.setLineNumber($binaryOp.getLine());
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionMult returns [Expression synExpression]
    :
        lExpr = expressionUnary rExpr = expressionMultTemp[$lExpr.synExpression]
        {
            $synExpression = $rExpr.synExpression;
        }
    ;
    expressionMultTemp[Expression inhExpression] returns [Expression synExpression]
    :
        binaryOp = ('*' | '/') lExpr = expressionUnary
        {
            Expression expr;
            if($binaryOp.text.equals("*"))
                expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.mult);
            else
                 expr = new BinaryExpression($inhExpression, $lExpr.synExpression, BinaryOperator.div);

        }
        rExpr = expressionMultTemp[expr]
        {
            $synExpression = $rExpr.synExpression;
            $synExpression.setLineNumber($binaryOp.getLine());
        }
        |
        {
            $synExpression = $inhExpression;
        }
    ;
    expressionUnary returns [Expression synExpression]
    :
        val = '!' uExpr1 = expressionUnary
        {
            $synExpression = new UnaryExpression(UnaryOperator.not, $uExpr1.synExpression);
            $synExpression.setLineNumber($val.getLine());
        }
        |val = '-' uExpr2 = expressionUnary
        {
            $synExpression = new UnaryExpression(UnaryOperator.minus, $uExpr2.synExpression);
            $synExpression.setLineNumber($val.getLine());
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
            {
                $synExpression = new ArrayCall($instance.synExpression, $index.synExpression);
            }
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
        inhInstance = expressionOther method = expressionMethodsTemp[$inhInstance.synExpression]
        {
            if($method.synExpression != null)
                $synExpression = $method.synExpression;
            else
                $synExpression = $inhInstance.synExpression;
        }
    ;
    expressionMethodsTemp[Expression inhExpression] returns [Expression synExpression]
    :
        '.'
        {
            Expression method = null;
        }
        (methodName = ID '(' ')'
        {
            method = new MethodCall($inhExpression, new Identifier($methodName.text));
//            method.setLineNumber($methodName.getLine());
        }
        | methodName = ID '(' ( arg1 = expression
        {
            method = new MethodCall($inhExpression, new Identifier($methodName.text));
            ((MethodCall)method).addArg($arg1.synExpression);
//            method.setLineNumber($methodName.getLine());
        }
        (',' arg = expression{((MethodCall)method).addArg($arg.synExpression);})*) ')'
        | 'length'
        {
            method = new Length($inhExpression);
        }
        )
        {
            if(method == null) {
                method = $inhExpression;
            }
        }
        expr = expressionMethodsTemp[method]
        {
            if($expr.synExpression != null)
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
    val = CONST_NUM {$synExpression = new IntValue($val.int, new IntType()); $synExpression.setLineNumber($val.getLine());}
          |   val = CONST_STR {$synExpression = new StringValue($val.text, new StringType()); $synExpression.setLineNumber($val.getLine());}
          |   'new ' 'int' '[' val = CONST_NUM ']' {NewArray arr = new NewArray(); arr.setExpression(new IntValue($val.int, new IntType())); arr.setLineNumber($val.getLine()); $synExpression = arr;}
          |   'new ' className = ID '(' ')' {$synExpression = new NewClass(new Identifier($className.text)); $synExpression.setLineNumber($className.getLine());}
          |   'this' {$synExpression = new This();}
          |   'true' {$synExpression = new BooleanValue(true, new BooleanType());}
          |   'false' {$synExpression = new BooleanValue(false, new BooleanType());}
          |   val = ID {$synExpression = new Identifier($val.text); $synExpression.setLineNumber($val.getLine());}
          |   val = ID '[' ex = expression ']' {$synExpression = new ArrayCall(new Identifier($val.text), $ex.synExpression); $synExpression.setLineNumber($val.getLine());}
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