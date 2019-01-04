.class public A
.super java/lang/Object

.field protected x I

.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test1()I
   .limit stack 100
   .limit locals 100

   ldc 2
   newarray int
   astore 2


   aload 2
   ldc 0
   ldc 1200
   iastore

   aload 2
   ldc 1
   ldc 1201
   iastore

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokestatic java/util/Arrays.toString([I)Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


   ldc 0
   ireturn
.end method


