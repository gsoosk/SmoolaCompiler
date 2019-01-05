.class public LoopTest
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public testLoop()I
   .limit stack 100
   .limit locals 100

   ; Assign
   iconst_1
   istore 17

   ; Assign
   ldc 12
   istore 14

   ; Assign
   ldc 13
   istore 15

   ; Assign
   ldc 0
   istore 16

   ; While
Label8:
   iload 17
   ifeq Label9
   iload 16
   iload 14
   iadd
   iload 15
   iadd
   istore 16
   iload 14
   iload 15
   imul
   istore 16
   goto Label8 
Label9:

   ; Conditional
   iload 14
   iload 15
   if_icmpne Label10
   iconst_1
   goto Label11
Label10:
   iconst_0
Label11:
   ifeq Label12
   iload 14
   iload 15
   iload 14
   imul
   ldc 2
   imul
   iadd
   istore 16
   ldc 12
   iload 16
   imul
   istore 16
   goto Label13
Label12:
   ldc 14
   iload 14
   imul
   iload 15
   idiv
   istore 16
Label13:

   ldc 0

   ireturn
.end method


