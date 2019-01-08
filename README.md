# Smoola Compiler
### What does it do ? 
This is a compiler for Smoola language.

In Phase 1 lexer of smoola made in smoola.g4 using Antlr

In Phase 2 of project it makes AST from lexer analysis and make SymbolTable. At last it shows up semantic Errors.

In Phase 3 of project it shows remaining errors and do type checking.

In Phase 4 Java byte code of smoola code will be generated.

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

## PHASE4 ( Code Generation)
* All kind of code generations handled in this phase of Compiler.
* This compiler make `Java Byte Code`s using jasmin assembler. 
* After all Smoola Code runs on Java Virtual Machine.

## How to run ? 
#### Step 1 :
You should at first `generate` Smoola.g4 grammer using Antlr. For more info about Antlr visit [This](https://www.antlr.org) Page.
#### Step 2 : 
You should run whole java project. For running that you can use MySmoola.java script. If you run this code it runs whole project easily.
#### Step 3 : 
After running java project Java Byte Codes will create in `output` folder. Then its time to run generated code.
First go to `output` repository in terminal. then run
```
java -jar jasmin.jar *.j
```
and then it will create java classes. Then you should run code with running code of your main class :
```
java <MainClass>
```
