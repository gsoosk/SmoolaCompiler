grammar Smoola;
    program:
        mainClass (classDeclaration)* EOF
    ;
    mainClass:
        // name should be checked later
        'class' ID '{' 'def' ID '(' ')' ':' 'int' '{'  statements 'return' expression ';' '}' '}'
    ;
    classDeclaration:
        'class' ID ('extends' ID)? '{' (varDeclaration)* (methodDeclaration)* '}'
    ;
    varDeclaration:
        'var' ID ':' type ';'
    ;
    methodDeclaration:
        'def' ID ('(' ')' | ('(' ID ':' type (',' ID ':' type)* ')')) ':' type '{'  varDeclaration* statements 'return' expression ';' '}'
    ;
    statements:
        (statement)*
    ;
    statement:
        statementBlock |
        statementCondition |
        statementLoop |
        statementWrite |
        statementAssignment
    ;
    statementBlock:
        '{'  statements '}'
    ;
    statementCondition:
        'if' '('expression')' 'then' statement ('else' statement)?
    ;
    statementLoop:
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