.class public B
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test1()I
   .limit stack 100
   .limit locals 100

   ldc 100
   newarray int
   astore 9



   ldc 10
   newarray int
   astore 8



   ldc 10000
   istore 6



   ldc 2
   istore 7



   aload 8
   aload 9
   invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z
   istore 12



   iload 6
   iload 7
   if_icmpge Label0
   iconst_1
   goto Label1
Label0:
   iconst_0
Label1:
   istore 10



   iload 6
   iload 7
   if_icmpne Label2
   iconst_1
   goto Label3
Label2:
   iconst_0
Label3:
   istore 11



   iload 10
   ifne Label4
   iload 12
   ifne Label4
   iconst_0
   goto Label5
Label4:
   iconst_1
Label5:
   ifne Label6
   iconst_1
   goto Label7
Label6:
   iconst_0
Label7:
   istore 13



   iload 7
   ineg
   istore 6



   ldc 0

   ireturn
.end method


