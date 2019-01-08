
##Created By Farzad
class MainClass
{
    def main() : int
    {

        writeln("Hello This is a test");
        writeln("Factorial of 6 is :");
        writeln(new A().calculateFactorial(6));
        new B().binaryExprCheck();
        new assignTest().test();
        new FakeMain().fakeMain();
        return 0;
    }
}
class FakeMain
{
    def fakeMain() : int
    {
        var loopTest : LoopTest;
        var arr : int[];
        var temp : int;
        arr = new int[10];

        loopTest = new LoopTest();
        arr = loopTest.initArr(arr);
        arr = loopTest.bubbleSort(arr);
        writeln("Sorted : ");
        writeln(arr);

        temp = this.qTest();

        return 0;
    }
    def qTest() : int
    {

        var q : Queue;
        var temp : int;
        q = new Queue();
        writeln("Initializing queue...");
        writeln("adding 3, 2, 5, 7 to queue");
        temp = q.push(3);
        temp = q.push(2);
        temp = q.push(5);
        temp = q.push(7);
        writeln("front of queue : ");
        writeln(q.front());
        writeln("queue after front value pop is :");
        temp = q.print();
        return 0;
    }
}
class A
{
    var fact : int;
    def calculateFactorial(input : int) : int
    {
        var i : int;
        i = input;
        fact = 1;
        while(i <> 0)
        {
            fact = fact * i;
            i = i - 1;
        }
        return fact;
    }

}
class B extends A
{
    def binaryExprCheck() : int
    {
        var x : int;
        var y : int;
        var b : boolean;

        x = fact + 12 * 123 + x / 12;
        if( (y == fact) && b ) then
        {
            writeln("It's ok");
        }
        else
        {
            writeln("It's not ok");
        }

        return 0;
    }
}
class LoopTest
{

    var sortedArray : int [];
    var a : int;
    var b : int;
    def initArr ( arr : int[]) : int []
    {

        var i : int;

        while( i < 10 )
        {
            arr[i] = i;
            i = i + 1;
        }
        writeln("Unsorted array :");
        writeln(arr);
        return arr;

    }
    def bubbleSort( arr : int[]) : int[]
    {
        var i : int;
        var j : int;
        var size : int;
        var swapped : boolean;
        var temp : int;
        swapped = false;
        i = 0;
        j = 0;
        size = arr.length;
        while(i < size - 1)
        {

            swapped = false;
            j = 0;
            while ( j < size - i - 1 )
            {
                if( arr[j] < arr [j+1] ) then
                {
                    a = arr[j];
                    b = arr[j+1];
                    temp = this.swapAB();
                    arr[j] = a;
                    arr[j+1] = b;
                    swapped = true;
                }
                j = j + 1;
            }

            if(!swapped) then
            {
                i = size + 1; # to break !
            }
            i = i + 1;
        }
        sortedArray = arr;
        return arr;
    }
    def swapAB() : int
    {
        var temp : int;
        temp = a;
        a = b;
        b = temp;
        return 0;
    }

}
class assignTest
{
    var b : int;
    def test() : int
    {
        var a : int[];
        var c : int;
        var d : int;
        writeln("assignTest:");
        d = 12;
        a = new int[10];
        a[0] = b = c = d;
        writeln(d);
        writeln(c);
        writeln(b);
        writeln(a);
        return 0;
    }
}
class Queue
{
    var q : int[];
    var size : int;
    def initQ() : int
    {
       q = new int[10];
       size = 0;
       return 0;
    }
    def front() : int
    {

        var newQ : int[];
        var toReturn : int;
        var i : int;
        newQ = new int[10];
        if(q.length > 0) then
        {
            i = 0 ;
            while(i < size - 1)
            {
                newQ[i] = q[i];
                i = i + 1;
            }
            toReturn = q[i];
            size = size - 1;
        }
        else
        {
            writeln("Q is empty!");
        }
        q = newQ;
        return toReturn;
    }
    def push(member : int) : int
    {
        var newQ : int[];
        var toReturn : int;
        var i : int;
        newQ = new int[10];
        if(size < 10) then
        {
            i = 0 ;
            while(i < size)
            {
                newQ[i] = q[i];
                i = i + 1;
            }
            newQ[i] = member;
            q = newQ;
            size = size + 1;
        }
        else
        {
            writeln("Size of Q is maximum!");
        }

        return 0;
    }
    def print() : int
    {
        var i : int;
        while( i < size )
        {
            writeln(q[i]);
            i = i + 1;
        }
        return 0;
    }
}


