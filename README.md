# Smoola Compiler
### What does it do ? 
This is a compiler for Smoola language.

In Phase 1 lexer of smoola made in smoola.g4 using Antlr

In Phase 2 of project it makes AST from lexer analysis and make SymbolTable. At last it shows up semantic Errors.

In Phase 3 of project it shows remaining errors and do type checking.

## PHASE1 (LEXER)
checking grammer of language.

## PHASE2 ( Semantics )
### Errors 
* Redefination of Methods 
* Redefination of Variables
* Redefination of Classes
* New Array zero length 

## PHASE3 ( Type Checking )
### Errors ( Main Errors ) 
* Refrence to a undeclared variable
* Unsupported operand type using 
* Type checking all conditions and statements
* Unsupported usage of method calls
* writeln type check
* Not validation of left side of assignment
* return type validation
* and all other compile errors...

## How to run ? 
You should at first `generate` Smoola.g4 grammer using Antlr. and then running whole project. 
For more info about Antlr visit [This](https://www.antlr.org) Page.
