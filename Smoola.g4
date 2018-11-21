grammar Smoola;

@members{
    
}
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

    expression returns [Expression synExpression]:
		expr = expressionAssignment
		{
		    $synExpression = $expr;
		}
	;

    expressionAssignment returns [Expression synExpression]:
		lExpr = expressionOr '=' rExpr = expressionAssignment
		{
		    $synExpression = new BinaryExpression(lExpr, rExpr, BinaryOperator.assign);

		}
	    |	expr = expressionOr
	    {
	        $synExpression = $expr;
	    }
	;

    expressionOr:
		expressionAnd expressionOrTemp
	;

    expressionOrTemp:
		'||' expressionAnd expressionOrTemp
	    |
	;

    expressionAnd:
		expressionEq expressionAndTemp
	;

    expressionAndTemp:
		'&&' expressionEq expressionAndTemp
	    |
	;

    expressionEq:
		expressionCmp expressionEqTemp
	;

    expressionEqTemp:
		('==' | '<>') expressionCmp expressionEqTemp
	    |
	;

    expressionCmp:
		expressionAdd expressionCmpTemp
	;

    expressionCmpTemp:
		('<' | '>') expressionAdd expressionCmpTemp
	    |
	;

    expressionAdd:
		expressionMult expressionAddTemp
	;

    expressionAddTemp:
		('+' | '-') expressionMult expressionAddTemp
	    |
	;

        expressionMult:
		expressionUnary expressionMultTemp
	;

    expressionMultTemp:
		('*' | '/') expressionUnary expressionMultTemp
	    |
	;

    expressionUnary:
		('!' | '-') expressionUnary
	    |	expressionMem
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