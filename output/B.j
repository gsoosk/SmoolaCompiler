.class public B
.super java/lang/Object


.method public <init>()V
   aload_0 ; push this
   invokespecial java/lang/Object/<init>()V ; call super
   return
.end method

.method public test1()I
   .limit stack 1000
   .limit locals 1000

   ; Assign
   ldc 100
   newarray int
   astore 13

   ; Assign
   ldc 10
   newarray int
   astore 12

   ; Assign
   ldc 1
   istore 10

   ; Assign
   ldc 2
   istore 11

   ; Assign
   aload 12
   aload 13
   invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z
   istore 16

   ; Assign
   iload 10
   iload 11
   if_icmpge Label0
   iconst_1
   goto Label1
Label0:
   iconst_0
Label1:
   istore 14

   ; Assign
   iload 10
   iload 11
   if_icmpne Label2
   iconst_1
   goto Label3
Label2:
   iconst_0
Label3:
   istore 15

   ; Assign
   iload 14
   ifne Label4
   iload 16
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
   istore 17

   ; Assign
   iload 11
   ineg
   istore 10

   ldc 0

   ireturn
.end method


