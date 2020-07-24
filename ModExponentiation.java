package operations;

public class ModExponentiation {
    private int a,b,m ;
    private long c ;

    public ModExponentiation (int a , int b ,int m){
        this.a = a;
        this.b = b;
        this.m = m;
    }

    public long naive1Iterative(){
        c = 1 ;
        for (int i = 1 ; i <= b ; i++){
            c = c * a;
        }
        c = c % m ;
        return c ;
    }
    //temp in order to save the b value for the return condition
    public long naive1Recursive(int temp){
        c = 1 ;
        if (temp > 0) {
            temp--;
            c = naive1Recursive(temp) * a ;
        }
        if ( temp == b-1) {
            return c % m ;
        }
        else {
            return c ;
        }
    }

    public long naive2Iterative(){
        c = 1;
        for (int i = 1 ; i <= b ; i++){
            c = (c * a ) % m ;
        }
        return c ;
    }

    public long naive2Recursive(){
        c = 1 ;
        if (b > 0) {
            b--;
            c = (naive2Recursive() * a) % m ;
        }
        return c ;
    }

}

