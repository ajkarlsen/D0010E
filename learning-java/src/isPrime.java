public class isPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(7523));
    }
    static boolean isPrime(int n) {
        int i = 2;
        while (i < Math.sqrt(n)) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
