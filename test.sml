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
class AC {

}
class BC extends AC {

}
class CC extends BC {

}
class a extends c {

    def test() : AC {
        var d: AC;
        d = new AC();
        return d;
    }
}
