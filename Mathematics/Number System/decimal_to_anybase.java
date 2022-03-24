class decimal_to_anybase {
    public static void decimalToAnybase(int num, int destinationBase) {
        int ans = 0;
        int pow = 1; // 10 ^ 0 = 1;
        while(num > 0) {
            int d = num % destinationBase;
            ans = ans + d * pow;
            pow = pow * 10;
            num = num / destinationBase;
        }
        System.out.println("Base "+destinationBase+" value of the decimal number is "+ ans);
    }
    public static void main(String[] args) {
        decimalToAnybase(653, 8);
    }
}
