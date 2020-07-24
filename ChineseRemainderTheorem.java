package operations;

public class ChineseRemainderTheorem {

    public int[] CRT (int [] m , int A , int B ) {

        int i;
        int [] c = new int[m.length] ;
        int [] d = new int[m.length] ;
        long M = 1 ;
        long C = 0 ;
        long D = 0 ;
        //stores the mod addition and multiplication
        for (i = 0 ; i < m.length ; i++) {
            c[i] = ((A % m[i]) + (B % m[i])) % m[i] ;
            d[i] = ((A % m[i]) * (B % m[i])) % m[i] ;
            M *= m[i] ;
        }

        //object for computing bezout coefficient for the inverse
        ExtendedEuclideanAlgorithm inverse = new ExtendedEuclideanAlgorithm();
        //applying Chinese Remainder Theorem
        for (i = 0 ; i < m.length ; i++) {
            int x = c[i] ;
            int y = (int) (M / m[i]);
            int z = y % m[i] ;
            C += (x) * (y) * (inverse.extendedGCD(m[i] , z)[2])  ;
            x = d[i] ;
            D += (x) * (y) * (inverse.extendedGCD( m[i] , z)[2])  ;
        }
        int[] result = new int[2] ;
        result[0] = (int) (C % M);
        result[1] = (int) (D % M);
        return result;
    }

    public static void main(String[] args) {
        ChineseRemainderTheorem sr = new ChineseRemainderTheorem();
        //addition
        System.out.println(sr.CRT(new int[] {9 , 7 , 5 , 4} , 112 , 34)[0]);
        //multiplication
        System.out.println(sr.CRT(new int[] {9 , 7 , 5 , 4} , 15 , 3)[1]);
    }
}
