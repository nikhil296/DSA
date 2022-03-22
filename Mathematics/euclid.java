// Complexity = O(log max(a, b))
class euclid {
    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args)
    {
        int a = 959, b = 10000007, g;
        g = gcd(a, b);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);
         
        a = 99; b = 1000000007;
        g = gcd(a, b);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);
         
        a = 31; b = 2;
        g = gcd(a, b);
        System.out.println("GCD(" + a +  " , " + b+ ") = " + g);
    }
}
