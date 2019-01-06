.class public fieldTest
.super java/lang/Object

.field protected x I
.field protected y I

.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super

   ;Initializing x
   aload_0
   iconst_0
   putfield fieldTest/x I

   ;Initializing y
   aload_0
   iconst_0
   putfield fieldTest/y I
   return
.end method

.method public test(ILjava/lang/String;)Ljava/lang/String;
   .limit stack 1000
   .limit locals 1000

   ;Initializing l1
   iconst_0
   iconst_0
   istore 3

   ; Assign
   aload_0
   getfield fieldTest/x I
   aload_0
   getfield fieldTest/y I
   iadd
   iload 1
   iadd
   istore 3

   ldc ""

  areturn
.end method


