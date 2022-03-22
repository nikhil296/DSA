import java.util.*;
class lowest_highest_prime_factors {
    public static void prime_factors(int n) {
        // to find the "Lowest" and "Highest" prime factors for all integers less than 'n'.
        int lowest[] = new int[n+1]; // this "lowest[]" array will also work as "spf[]" array.
        int highest[] = new int[n+1];
        for(int i = 2; i <= n; i++) {
            if(lowest[i] == 0) {
                lowest[i] = i;
                highest[i] = i;
                for(int j = i*2; j<=n; j += i) {
                    highest[j] = i;
                    if(lowest[j] == 0) {
                        lowest[j] = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(lowest));
        System.out.println(Arrays.toString(highest));
    }
    public static void main(String[] args) {
        prime_factors(20);
    }
}
