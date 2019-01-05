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
   istore 21

   ; Assign
   ldc 12
   istore 18

   ; Assign
   ldc 13
   istore 19

   ; Assign
   ldc 0
   istore 20

   ; While
Label8:
   iload 21
   ifeq Label9
   iload 20
   iload 18
   iadd
   iload 19
   iadd
   istore 20
   iload 18
   iload 19
   imul
   istore 20
   goto Label8 
Label9:

   ; Conditional
   iload 18
   iload 19
   if_icmpne Label10
   iconst_1
   goto Label11
Label10:
   iconst_0
Label11:
   ifeq Label12
   iload 18
   iload 19
   iload 18
   imul
   ldc 2
   imul
   iadd
   istore 20
   ldc 12
   iload 20
   imul
   istore 20
   goto Label13
Label12:
   ldc 14
   iload 18
   imul
   iload 19
   idiv
   istore 20
Label13:

   ldc 0

   ireturn
.end method


