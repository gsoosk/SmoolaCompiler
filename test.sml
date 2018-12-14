class b {

    def main() : int {

        return 2;
    }
}
class c extends b{

    def test2(x1 : int) : int {

        return 2;
    }
}
class AC {

}
class BC extends AC {

}
class CC extends BC {

}
class a extends c {

    def test() : AC {
        var d: CC;
        d = 1;
        return d;
    }
}
