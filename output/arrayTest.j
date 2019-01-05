.class public arrayTest
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test()I
   .limit stack 100
   .limit locals 100

   ; Assign
   ldc 10
   newarray int
   astore 18

   ; Assign
   ldc 12
   newarray int
   astore 19

   ; Write
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 18
   arraylength 
   aload 19
   arraylength 
   iadd
   invokevirtual java/io/PrintStream/println(I)V

   ldc 0

   ireturn
.end method


