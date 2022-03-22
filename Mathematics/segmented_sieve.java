import java.util.*;
class segmented_sieve {
    static ArrayList<Long> prime = new ArrayList<>();
    public static void sieveN(int n) {
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
        // The prime numbers are represented by "0", i.e prime[x] = 0.
        for(int i = 2; i<=n; i++) {
            if(spf[i] == i) {
                prime.add((long)i);
            }
        }
    }
    public static void seg_sieve(long l, long r) {
        int n = (int)(r-l+1);
        boolean p[] = new boolean[n];
        Arrays.fill(p, true);
        for(int i = 0; i<prime.size(); i++) {
            long x = prime.get(i);
            long base = (l/x) * x;
            if(base < l) {
                base += x;
            }
            for(long j = base; j <= r; j += x) {
                int index = (int)(j - l);
                p[index] = false;
            }
            if(base == x) {
                // if (l is prime) then base will start from a "prime number" 
                // and in above loop that gets marked s a non-prime number, so here we unmark it.
                p[(int)(base - l)] = true;
            }
        }
        for(int i = 0; i<n; i++) {
            if(p[i] == true) {
                System.out.println(i + l +" ");
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        // we need prime numbers from "2 to sqrt(r)"
        sieveN((int)Math.sqrt(r));
        seg_sieve(l, r);
    }
}
