public class GCD {
    public static void main(String[] args) {
        for (int i = 11, j = 9; i <= 19; i++, j--) {
            System.out.println("gcd(" + i + ", " + j + ") = " + gcd(i, j));
        }
    }

    static int gcd(int a, int b) {
        int c;
        do {
            c = a % b;
            a = b;
            b = c;
        } while (c != 0);
        return a;
    }
}
