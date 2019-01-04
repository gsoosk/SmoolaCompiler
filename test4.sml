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
        t = b1 || b2 || b;

        return 0;
    }
}
