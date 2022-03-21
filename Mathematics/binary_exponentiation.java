import java.io.*;
import java.util.*;
class expo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(binExpo(a, b));
    }
    public static long binExpo(long a, long b) {
// for a <= 10^9 b <= 10^9 m <= 10^9
        long m = (long) (1e9 + 7);
        if(b == 0) {
            return 1;
        }
        long res = 1;
        while(b>0) {
            if(b%2 == 1) {
                res = (res * a)%m;
            }
            b = b >> 1;
            a = (a * a)%m;
        }
        return res;
    }
}