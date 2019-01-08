##Created By Farzad
class MainClass
{
    def main() : int
    {
        new assignTest().test();
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
        d = 12;
        a = b = c = d;
        writeln(d);
        writeln(c);
        writeln(b);
        writeln(a);
        return 0;
    }
}
