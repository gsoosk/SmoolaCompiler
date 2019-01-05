.class public m
.super java/lang/Object


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
   astore 21

   ldc 0

   ireturn
.end method


