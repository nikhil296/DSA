import java.util.ArrayList;
class sieve_linear_time {
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void sieve_n(int n) {
        // The smallest prime factor array.
        int spf[] = new int[n+1];
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(spf[i] == 0) {
                // if spf[x] is "0" then the number "x" is prime.
                // spf[x] = x, for "x" as prime.
                spf[i] = i;
                temp.add(i);
            }
            for(int j = 0; j<temp.size() && temp.get(j) <= spf[i] && temp.get(j)*i <= n; j++) {
                spf[temp.get(j)*i] = temp.get(j);
            }
        }
        // we store all the prime numbers in the global ArrayList "prime".
        for(int i = 2; i<=n; i++) {
            if(spf[i] == i) {
                prime.add(i);
            }
        }
    }
}
