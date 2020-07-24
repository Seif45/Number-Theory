package operations;

//Facade design pattern
public class Facade {

    public long[] modExponentiation(int a , int b , int m) {
        long[] result = new long[4] ;
        ModExponentiation me = new ModExponentiation(a , b , m) ;
        result[0] = me.naive1Iterative();
        result[1] = me.naive1Recursive(b);
        result[2] = me.naive2Iterative();
        result[3] = me.naive2Recursive();
        return result ;
    }

    public int[] extendedEuclidean (int a , int b){
        ExtendedEuclideanAlgorithm eea = new ExtendedEuclideanAlgorithm();
        return eea.extendedGCD(a ,b) ;
    }

    public int[] chineseRT (int[] m , int A , int B) {
        ChineseRemainderTheorem crt = new ChineseRemainderTheorem();
        return crt.CRT(m , A , B) ;
    }

    public void primeNumberGenerator (int n) {
        PrimeNumberGenerator png = new PrimeNumberGenerator();
        png.Sieve(n);
    }
}
