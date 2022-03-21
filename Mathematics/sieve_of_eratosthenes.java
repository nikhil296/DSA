class sieve_of_eratosthenes {
    public static int[] sieve(int n) {
        int prime[] = new int[n+1];
        Arrays.fill(prime, 0);
        prime[0] = 1;
        prime[1] = 1;
        for(int i = 2; i*i <= n; i++) {
            if(prime[i] == 0) {
                for(int j = i * i; j<=n; j += i) {
                    prime[j] = i;
                }
            }
        }
        // The prime numbers are represented by "0", i.e prime[x] = 0.
        return prime;
    }
}
