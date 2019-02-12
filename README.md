# Smoola Compiler
### What does it do? 
This is a compiler for Smoola language. (You can see [Smoola Documentation](https://github.com/gsoosk/SmoolaCompiler/wiki/Smoola-Documentation))

In [Phase 1](#phase1-lexer), the lexer of Smoola is made in Smoola.g4 using [Antlr](https://github.com/antlr/antlr4)

In [Phase 2](#phase2-semantics), the AST is constructed from lexical analysis and the symbol table is filled. Finally, it shows up semantic errors.

In [Phase 3](#phase3-type-checking), the remaining errors are shown and type-checking is done.

In [Phase 4](#phase4-code-generation), Java bytecode of the Smoola program will be generated.

## Phase 1 (Lexer)
Checking grammar of language.

## Phase 2 (Semantics)
### Errors 
* Redefinition of methods 
* Redefinition of variables
* Redefinition of classes
* New array with zero length 

## Phase 3 (Type-Checking)
### Errors (Main Errors) 
* Reference to an undeclared variable
* Unsupported usage of operand type 
* Type-checking all conditions and statements
* Unsupported usage of method calls
* `writeln` type-checking
* Not validation of left side of assignment
* Return type validation
* and all other compile errors...

## Phase 4 (Code Generation)
* All of the code generation process is handled in this phase.
* This compiler generates Java bytecode using [jasmin](http://jasmin.sourceforge.net/) assembler. 
* After all, the Smoola program is run on Java Virtual Machine.

## How to run? 
#### Step 1:
You should at first generate Smoola.g4 grammer using Antlr. For more info about Antlr visit [This](https://www.antlr.org) Page.
#### Step 2: 
You should run the whole Java project. For running that you can use MySmoola.java script. If you run this code, it runs the whole project easily.
#### Step 3: 
After running the Java project, Java bytecode will be generated in the `output` folder. Then it's time to run the generated code.
First go to the `output` directory in terminal. Then run
```
java -jar jasmin.jar *.j
```
and then it will create corresponding Java classes. Then you should run the program through executing your main class:
```
java <MainClass>
```
