.class public LoopTest
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public testLoop()I
   .limit stack 1000
   .limit locals 1000

   ; Assign
   iconst_1
   istore 4

   ; Assign
   ldc 12
   istore 1

   ; Assign
   ldc 13
   istore 2

   ; Assign
   ldc 0
   istore 3

   ; While
Label8:
   iload 4
   ifeq Label9
   iload 3
   iload 1
   iadd
   iload 2
   iadd
   istore 3
   iload 1
   iload 2
   imul
   istore 3
   goto Label8 
Label9:

   ; Conditional
   iload 1
   iload 2
   if_icmpne Label10
   iconst_1
   goto Label11
Label10:
   iconst_0
Label11:
   ifeq Label12
   iload 1
   iload 2
   iload 1
   imul
   ldc 2
   imul
   iadd
   istore 3
   ldc 12
   iload 3
   imul
   istore 3
   goto Label13
Label12:
   ldc 14
   iload 1
   imul
   iload 2
   idiv
   istore 3
Label13:

   ldc 0

   ireturn
.end method


