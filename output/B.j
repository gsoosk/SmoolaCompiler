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

   ;Initializing x
   iconst_0
   iconst_0
   istore 1

   ;Initializing y
   iconst_0
   iconst_0
   istore 2

   ;Initializing b1
   iconst_0
   iconst_0
   istore 5

   ;Initializing b2
   iconst_0
   iconst_0
   istore 6

   ;Initializing b
   iconst_0
   iconst_0
   istore 7

   ;Initializing t
   iconst_0
   iconst_0
   istore 8

   ; Assign
   ldc 100
   newarray int
   astore 4

   ; Assign
   ldc 10
   newarray int
   astore 3

   ; Assign
   ldc 1
   istore 1

   ; Assign
   ldc 2
   istore 2

   ; Assign
   aload 3
   aload 4
   invokevirtual java/lang/Object.equals(Ljava/lang/Object;)Z
   istore 7

   ; Assign
   iload 1
   iload 2
   if_icmpge Label0
   iconst_1
   goto Label1
Label0:
   iconst_0
Label1:
   istore 5

   ; Assign
   iload 1
   iload 2
   if_icmpne Label2
   iconst_1
   goto Label3
Label2:
   iconst_0
Label3:
   istore 6

   ; Assign
   iload 5
   ifne Label4
   iload 7
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
   istore 8

   ; Assign
   iload 2
   ineg
   istore 1

   ldc 0

   ireturn
.end method


