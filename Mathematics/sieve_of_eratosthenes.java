import java.util.*;
class sieve_of_eratosthenes {
    static ArrayList<Integer> prime = new ArrayList<>();
    public static int[] sieve(int n) {
        int p[] = new int[n+1];
        Arrays.fill(p, 0);
        p[0] = 1;
        p[1] = 1;
        for(int i = 2; i*i <= n; i++) {
            if(p[i] == 0) {
                for(int j = i * i; j<=n; j += i) {
                    p[j] = i;
                }
            }
        }
        // The prime numbers are represented by "0", i.e prime[x] = 0.
        for(int i = 2; i<=n; i++) {
            if(p[i] == 0) {
                prime.add(i);
            }
        }
    }
}
