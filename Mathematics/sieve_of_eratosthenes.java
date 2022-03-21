class sieve_of_eratosthenes {
    public static boolean[] sieve(int n) {
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
        return prime;
    }
}
