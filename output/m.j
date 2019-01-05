.class public m
.super java/lang/Object

.field protected y I

.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test()I
   .limit stack 1000
   .limit locals 1000

   ; Assign
   new arrayTest
   dup
   invokespecial  arrayTest/<init>()V
   astore 28

   ; Assign
   aload_0
   invokevirtual m/test()I
   istore 29

   ; Assign
   aload 28
   iload 29
   iload 29
   invokevirtual arrayTest/test(II)I
   istore 30

   ldc 0

   ireturn
.end method


