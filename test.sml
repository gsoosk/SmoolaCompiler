class b {

    def main() : int {

        return 2;
    }
}
class c extends b{

    def test2(x1 : int) : int {
        var x : int ;
        v = y + x ;
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
        var d: AC;
        var h: CC;
        d = h;
        return d;
    }
}
