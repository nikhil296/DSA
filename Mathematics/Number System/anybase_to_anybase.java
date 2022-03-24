class anybase_to_anybase {
    public static void anybaseToAnybase(int num, int originBase, int destinationBase) {
        int decimalNum = anybaseToDecimal(num, originBase);
        int ans = decimalToAnybase(decimalNum, destinationBase);
        System.out.println(ans);
    }
    public static int anybaseToDecimal(int num, int originBase) {
        int ans = 0;
        int pow = 1; // origin base ^ 0 = 1;
        while(num > 0) {
            int d = num%10;
            ans = ans + d * pow;
            pow = pow * originBase;
            num = num / 10;
        }
        return ans;
    }
    public static int decimalToAnybase(int num, int destinationBase) {
        int ans = 0;
        int pow = 1; // 10 ^ 0 = 1;
        while(num > 0) {
            int d = num % destinationBase;
            ans = ans + d * pow;
            pow = pow * 10;
            num = num / destinationBase;
        }
        return ans;
    }
    public static void main(String[] args) {
        anybaseToAnybase(1172, 8, 2);
    }
}
