
##Created By Farzad
class MainClass
{
    def main() : int
    {

        writeln("Hello This is a test");
        writeln("Factorial of 6 is :");
        writeln(new A().calculateFactorial(6));
        new B().binaryExprCheck();
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
        arr = new int[10];
        loopTest = new LoopTest();
        arr = loopTest.initArr(arr);
        arr = loopTest.bubbleSort(arr);
        writeln("Sorted : ");
        writeln(arr);
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
    def test() : int
    {
        var a : int;
        var c : int;
        var b : int;
        var d : int;
        a = b = c ;
        return 0;
    }
}



