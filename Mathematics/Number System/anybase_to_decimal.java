class anybase_to_decimal {
    public static void anybaseToDecimal(int num, int originBase) {
        System.out.print("Decimal form of "+num+" is ");
        int ans = 0;
        int pow = 1; // origin base ^ 0 = 1;
        while(num > 0) {
            int d = num%10;
            ans = ans + d * pow;
            pow = pow * originBase;
            num = num / 10;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        anybaseToDecimal(1215, 8);
    }
}