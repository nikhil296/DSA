// Complexity = O(log M)
import java.util.Scanner;
class pair {
    int x, y, gcd;
    public pair(int x, int y, int gcd) {
        this.x = x;
        this.y = y;
        this.gcd = gcd;
    }
}
// a = 959
// M = 10000007 is giving wrong answer for the first method. bcz of "Long" issue.
// 99
// 1000000007 giving different answer. bcz of "Long" issue.
class mod_multiplicative_inverse {
    public static void mmi_Naive(int a, int M) {
        for (int x = 1; x < M; x++) {
            long t = ((long)(a%M) * (x%M)) % M;
            if (t == 1) {
                System.out.println("MMI is : "+x);
                return;
            }
        }
        System.out.println("MMI does not exists");
    }
    public static pair mmi(int a, int M) {
        if(M == 0) {
            return new pair(1, 0, a);
        }
        pair temp = mmi(M, a % M);
        return new pair(temp.y, (temp.x - (a/M) * temp.y), temp.gcd);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int M = sc.nextInt();
        mmi_Naive(a, M);
        pair ans = mmi(a, M);
        if(ans.gcd != 1) {
            System.out.println("MMI does not exists");
        }else {
            int res = (ans.x % M + M) % M;
            System.out.println("MMI is : "+res);
        }
    }
}
