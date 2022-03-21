import java.util.*;
class sieve_of_eratosthenes {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i*i <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j<=n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
