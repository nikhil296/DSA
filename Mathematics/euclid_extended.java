class pair {
    int x, y, gcd;
    public pair(int x1, int y1, int gcd1) {
        x = x1;
        y = y1;
        gcd = gcd1;
    }
}
class euclid_extended {
    // x = y1
    // y = x1 - floor(a/b) * y1
    public static pair euclidExtended(int a, int b) {
        if(b == 0) {
            // ax + by = gcd(a, b) 
            // when (b == 0){ gcd(a, b) = a },
            // this means in the above equation for gcd to be 'a', 'x' should be 1 and 'y' as '0'.
            return new pair(1, 0, a); // pair(x, y, gcd)
        }
        pair temp = euclidExtended(b, a%b);
        return new pair(temp.y, (temp.x - ((a/b)*temp.y)), temp.gcd);
    }
}
