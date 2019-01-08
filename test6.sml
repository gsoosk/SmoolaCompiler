class Main
{
    def main() : int {
        new A().test();
        #writeln("*");
        return 0;
    }
}
class A
{
    var b : B;
    def test() : int {
        b = new B();
        writeln("*");
        return 0;
    }
}
class B {

}