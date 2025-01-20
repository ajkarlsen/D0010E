public class RiktigTriangel {
    public static void main(String[] args) {
        for (int a = 1; a <= 5; a++) {
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    System.out.println("(" + a + ", " + b + ", " + c + ") = " + riktigTriangel(a, b, c));
                }
            }
        }

    }
    static boolean riktigTriangel(double a, double b, double c) {
        return a <= b+c && b <= a+c && c <= a+b;
    }

}
