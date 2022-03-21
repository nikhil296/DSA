import java.util.ArrayList;
class sieve_linear_time {
    public static int[] sieve_n(int n) {
        // The smallest prime factor array.
        int spf[] = new int[n+1];
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(spf[i] == 0) {
                // if spf[x] is "0" then the number "x" is prime.
                // spf[x] = x, for "x" as prime.
                spf[i] = i;
                primes.add(i);
            }
            for(int j = 0; j<primes.size() && primes.get(j) <= spf[i] && primes.get(j)*i <= n; j++) {
                spf[primes.get(j)*i] = primes.get(j);
            }
        }
        return spf;
        // if(spf[i] == i) { "i" is prime; }
    }
}
