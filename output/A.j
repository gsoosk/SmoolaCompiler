.class public A
.super java/lang/Object

.field protected x I

.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test1()I
   .limit stack 1000
   .limit locals 1000

   ; Assign
   ldc 4
   newarray int
   astore 2

   ; Assign
   aload 2
   ldc 0
   ldc 1200
   iastore

   ; Assign
   aload 2
   ldc 1
   ldc 1201
   iastore

   ; Assign
   aload 2
   ldc 3
   ldc 1
   ldc 2
   iadd
   iastore

   ; Write
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   ; Assign
   ldc 12
   ldc 2
   ldc 4
   imul
   iadd
   ldc 23
   isub
   ldc 22
   ldc 23
   imul
   iadd
   istore 5

   ldc 0

   ireturn
.end method


