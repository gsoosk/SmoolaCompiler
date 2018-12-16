class b {
    def main() : int {
        writeln(false);
        return new c2().test2(1);
    }
}

class t extends u {

}
class i extends t{

}
class u extends i {

}

class c2 extends b2{

    def test2(x1 : int) : int {
        var x : int[] ;
        var y : int ;
        var z : int ;
        var cl1 : AC;
        var cl2 : BC;
        var cl3 : a ;
        var cl4 : y;
        var b1 : boolean;
        var b2 : boolean;
        cl1 = new NoClass();

        x = new int[1];
        y = cl3.test();
        x[2] = y+x[3];
        if( cl1 == cl3) then {

        }

        writeln(true);


        return 2;
    }
}
class AC {

}
class BC extends AC {

}
class CC extends BC {

}
class a extends c2 {

    def test() : AC {
        var d: AC;
        var h: CC;
        d = h;
        return d;
    }
}
