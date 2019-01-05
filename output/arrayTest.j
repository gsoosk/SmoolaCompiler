.class public arrayTest
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
   ldc 13
   istore 20

   ; Assign
   ldc 10
   newarray int
   astore 18

   ; Assign
   ldc 12
   newarray int
   astore 19

   ; Assign
   aload 19
   ldc 0
   ldc 12
   iastore

   ; Assign
   aload 18
   ldc 0
   aload 19
   ldc 0
   iaload
   iload 20
   ldc 15
   imul
   aload 19
   ldc 0
   iaload
   idiv
   iadd
   iastore

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


