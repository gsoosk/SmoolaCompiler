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
    statements returns [ArrayList<Statement> synStatements]:
        {
            $synStatements = new ArrayList<>(); ;
        }
        (newStatements = statement
        {
            $synStatements.add(newStatements);
        }
        )*
    ;
    statement returns [Statement synStatement]:
        stmB = statementBlock {$synStatement = $stmB.synStatementBlock} |
        stmC = statementCondition {$synStatement = $stmC.synStatementCondition} |
        stmL = statementLoop {$synStatement = $stmL} |
        stmW = statementWrite {$synStatement = $stmW} |
        stmA = statementAssignment {$synStatement = $stmA}
    ;
    statementBlock returns [Statement synStatementBlock]:
        '{'  allStatements = statements {$synStatementBlock.setBody(allStatements)} '}'
    ;
    statementCondition returns [Statement synStatementCondition]:
        'if' '(' conditionExp = expression')' 'then' consequenceBody = statement
         {
            $synStatementCondition = new Conditional($conditionExp , $consequenceBody.synStatement);
         }('else' altBody = statement
         {
            $synStatementCondition.setAlternativeBody(altBody.synStatement);
         }
         )?
    ;
    statementLoop returns [Statement syn]:
        'while' '(' expression ')' statement
    ;
    statementWrite:
        'writeln(' expression ')' ';'
    ;
    statementAssignment:
        expression ';'
    ;

    expression:
		expressionAssignment
	;

    expressionAssignment:
		expressionOr '=' expressionAssignment
	    |	expressionOr
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
    expressionOther:
		CONST_NUM
        |	CONST_STR
        |   'new ' 'int' '[' CONST_NUM ']'
        |   'new ' ID '(' ')'
        |   'this'
        |   'true'
        |   'false'
        |	ID
        |   ID '[' expression ']'
        |	'(' expression ')'
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