package operations;

public class ExtendedEuclideanAlgorithm {

    public int[] extendedGCD (int a , int b){
        int [] results = new int[3] ;
        int temp;
        int s = 0 , sPrev = 1 , t = 1 , tPrev = 0 ;
        int r , rPrev ;
        int q ;
        // if either equals zero then everything is zero
        if (a == 0 || b == 0 ) {
            results[0] = 0 ;
            results[1] = 0 ;
            results[2] = 0 ;

        }
        else {
            //store the smallest in r
            if (b < a){
                r = b ;
                rPrev = a ;
            }
            else {
                r = a ;
                rPrev = b ;
            }
            //the equations
            while (r != 0) {
                q = rPrev / r ;

                temp = rPrev ;
                rPrev = r ;
                r = temp - q * rPrev ;

                temp = sPrev ;
                sPrev = s ;
                s = temp - q * sPrev ;

                temp = tPrev ;
                tPrev = t ;
                t = temp - q * tPrev ;
            }
            results[0] = rPrev ;
            results[1] = sPrev ;
            //if they are equal
            if (a == b) {
                results[2] = 1 ;
            }
            //for the sign of t bezout coeff
            else if (a % b == 0) {
                results[2] = -1 ;
            }
            else {
                results[2] = tPrev ;
            }
        }
        return results ;
    }
}
