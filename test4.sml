class MainClass
{
    def main() : int {

        writeln(1200);
        return 0;
    }
}
class A
{
    var x : int;
    def test1() : int {
        var y : int[];
        var b1 : bool;
        var b2 : bool;
        var x : int;
        y = new int[4];
        y[0] = 1200;
        y[1] = 1201;
        y[3] = 1 + 2 ;
        writeln(y);

        x = 12 + 2 * 4 - 23 + 22 * 23 ;

        return 0;
    }
}
class B
{
    def test1() : int {
        var x : int;
        var y : int;
        var s1 : int[];
        var s2 : int[];
        var b1 : boolean;
        var b2 : boolean;
        var b : boolean;
        var t : boolean;
        s2 = new int[100];
        s1 = new int[10];
        x = 1;
        y = 2;
        #b = "12" == "13";
        b = s1 == s2;
        b1 = x < y;
        b2 = x == y;
        t = !(b1 || b);
        x = -y;

        return 0;
    }
}
class LoopTest
{
    def testLoop() : int {
        var x : int;
        var y : int;
        var z : int;
        var b : boolean;
        b = true;
        x = 12;
        y = 13;
        z = 0;
        while(b)
        {
            z = z + x + y;
            z = x * y;
        }

        if( x == y ) then
        {
            z = x + y * x * 2;
            z = 12 * z;
        }
        else
        {
            z = 14 * x / y;
        }

        return 0;
    }
}
class arrayTest
{
    def test(a : int, b : int) : int {
        var x : int[];
        var y : int[];
        var z : int;
        z = 13;
        x = new int[10];
        y = new int[12];
        a = a * 2;
        z = a + b;
        x[2] = z;

        y[0] = 12;
        x[0] = y[0] + z * 15 / y[0];
        writeln(x.length + y.length);
        return 0;
    }
}
class m
{
    var y : int;
    def test() : int {
        var x : arrayTest ;
        var z : int;
        var t : int;
        x = new arrayTest();
        z = this.test();
        t = x.test(z, z);
        return 0;
    }
}