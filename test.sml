class b {

    def main() : int {

        return 2;
    }
}
class c {

    def test2() : int {

        return 2;
    }
}
class a extends c {

    def test() : int {
        var d: c;
        d = new c();
        return 1 + "Hello";
    }
}
