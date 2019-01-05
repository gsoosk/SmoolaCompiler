.class public arrayTest
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test(II)I
   .limit stack 1000
   .limit locals 1000

   ; Assign
   ldc 13
   istore 5

   ; Assign
   ldc 10
   newarray int
   astore 3

   ; Assign
   ldc 12
   newarray int
   astore 4

   ; Assign
   iload 1
   ldc 2
   imul
   istore 1

   ; Assign
   iload 1
   iload 2
   iadd
   istore 5

   ; Assign
   aload 3
   ldc 2
   iload 5
   iastore

   ; Assign
   aload 4
   ldc 0
   ldc 12
   iastore

   ; Assign
   aload 3
   ldc 0
   aload 4
   ldc 0
   iaload
   iload 5
   ldc 15
   imul
   aload 4
   ldc 0
   iaload
   idiv
   iadd
   iastore

   ; Write
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   arraylength 
   aload 4
   arraylength 
   iadd
   invokevirtual java/io/PrintStream/println(I)V

   ldc 0

   ireturn
.end method


