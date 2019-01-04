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

   ldc 1
   istore 6



   ldc 2
   istore 7



   iload 6
   iload 7
   if_icmpne 0
   iconst_1
   goto 1
0: iconst_0
1:   istore 8



   iload 6
   iload 7
   if_icmpeq 2
   iconst_1
   goto 3
2: iconst_0
3:   iload 6
   iload 7
   if_icmpne 4
   iconst_1
   goto 5
4: iconst_0
5:   istore 8



   ldc 0

   ireturn
.end method


