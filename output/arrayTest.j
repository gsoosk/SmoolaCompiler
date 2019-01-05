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
   istore 26

   ; Assign
   ldc 10
   newarray int
   astore 24

   ; Assign
   ldc 12
   newarray int
   astore 25

   ; Assign
   aload 25
   ldc 0
   ldc 12
   iastore

   ; Assign
   aload 24
   ldc 0
   aload 25
   ldc 0
   iaload
   iload 26
   ldc 15
   imul
   aload 25
   ldc 0
   iaload
   idiv
   iadd
   iastore

   ; Write
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 24
   arraylength 
   aload 25
   arraylength 
   iadd
   invokevirtual java/io/PrintStream/println(I)V

   ldc 0

   ireturn
.end method


