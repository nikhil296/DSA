public class sieve_of_Atkins {
    // sieve of Atkins is no better than other sieve algorithms for N < 10 billion,
    // so it is better we stick to other sieve algorithms.
    static void SieveOfAtkin(int N)
    {
        // 2 and 3 are known to be prime
        if (N > 2)
            System.out.print(2 + " ");
 
        if (N > 3)
            System.out.print(3 + " ");
 
        // Initialise the sieve array with
        // false values
        boolean sieve[] = new boolean[N+1];
 
        for (int i = 0; i <= N; i++)
            sieve[i] = false;
 
        /* Mark sieve[n] is true if one of the
        following is true:
        a) n = (4*x*x)+(y*y) has odd number
           of solutions, i.e., there exist
           odd number of distinct pairs
           (x, y) that satisfy the equation
           and    n % 12 = 1 or n % 12 = 5.
        b) n = (3*x*x)+(y*y) has odd number
           of solutions and n % 12 = 7
        c) n = (3*x*x)-(y*y) has odd number
           of solutions, x > y and n % 12 = 11 */
        for (int x = 1; x * x <= N; x++) {
            for (int y = 1; y * y <= N; y++) {
 
                // Main part of Sieve of Atkin
                int n = (4 * x * x) + (y * y);
                if (n <= N
                    && (n % 12 == 1 || n % 12 == 5))
 
                    sieve[n] ^= true;
 
                n = (3 * x * x) + (y * y);
                if (n <= N && n % 12 == 7)
                    sieve[n] ^= true;
 
                n = (3 * x * x) - (y * y);
                if (x > y && n <= N
                    && n % 12 == 11)
                    sieve[n] ^= true;
            }
        }
 
        // Mark all multiples of squares as
        // non-prime
        for (int r = 5; r * r <= N; r++) {
            if (sieve[r]) {
                for (int i = r * r; i <= N;
                     i += r * r)
                    sieve[i] = false;
            }
        }
 
        // Print primes using sieve[]
        for (int a = 5; a <= N; a++)
            if (sieve[a])
                System.out.print(a + " ");
        System.out.println();
    }
}
