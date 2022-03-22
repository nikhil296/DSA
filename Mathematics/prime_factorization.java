import java.util.ArrayList;

class prime_factorization {
    static int MAX = 1000001;
    static int spf[] = new int[MAX];
    public static void primeFactors(int n) {
        // complexity = O(log n)
        ArrayList<Integer> pf = new ArrayList<>();
        while(n % 2 == 0) {
            pf.add(2);
            n = n/2;
        }
        // now the number "n" is no more divisible by 2 that means it is odd.
        for(int i = 3; i*i <= n && n > 1; i += 2) {
            while(n % i == 0) {
                pf.add(i);
                n = n/i;
            }
        }
        // even now if "n" is not 1 then it has ben reduced to some other prime number that is > 2.
        if(n > 1){
            pf.add(n);
        }
        System.out.println(pf);
    }
    public static void primeFactors(int n) {
        // Prime Factorization using Sieve O(log n) for multiple queries.
        // The precomputation for smallest prime factor is done in O(n log(log n)) in the main function.
        ArrayList<Integer> pf = new ArrayList<>();
        while(n > 1) {
            pf.add(spf[n]);
            n = n/spf[n];
        }
        System.out.println(pf);
    }
    public static void primeFactors(int n) {
        // complexity = O(log n) if "n" is "composite" otherwise O(N).
        ArrayList<Integer> pf = new ArrayList<>();
        int counter = 2;
        while(n > 1) {
            if(n % counter == 0) {
                pf.add(counter);
                n = n/counter;
            }else {
                counter++;
            }
        }
        System.out.println(pf);
    }
    public static void sieveN() {
        spf[1] = 1; // we set this to avoid divide by '0' in "primeFactor" function.
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 2; i < MAX; i++) {
            if(spf[i] == 0) {
                // if spf[x] is "0" then the number "x" is prime.
                // spf[x] = x, for "x" as prime.
                spf[i] = i;
                temp.add(i);
            }
            for(int j = 0; j<temp.size() && temp.get(j) <= spf[i] && temp.get(j)*i < MAX; j++) {
                spf[temp.get(j)*i] = temp.get(j);
            }
        }
    }
    public static void main(String[] args) {
        sieveN();
        int n = 50;
        primeFactors(n);
    }
}
