class b {

    def main() : int {

        return 2;
    }
}
class a extends b {

    def test() : int {
        var i : int;
        var x : int;
        var y : int;
        var b1 : int;
        var b2 : boolean;
        i = (x + y + b1) ;

        while(x == ( x + y + x + 2 * x / i ) ){
             b1 = true;
        }
        while(x && ( x + y + x + 2 * x / i ) ){
             b1 = true;
        }
        if(x && ( x + y + x + 2 * x / i ) ) then {
             b1 = true;
        }


        return x;
    }
}
