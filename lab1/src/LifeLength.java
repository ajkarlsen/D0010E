import java.util.Scanner;

public class LifeLength {
    public static void main(String[] args) {
        while (true) {
            int a0;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("Skriv in ett heltal större än 0: ");
                a0 = scan.nextInt();
                System.out.println("Du skrev in " + a0);
                if (a0 == 0) {
                    scan.close();
                    break;
                } else {
                    System.out.println(iterLifeLength(a0));
                    System.out.println("f1(" + a0 + ") = " + f1(a0));
                    System.out.println("f2(" + a0 + ") = " + f2(a0));
                    System.out.println("f4(" + a0 + ") = " + f4(a0));
                    System.out.println("f8(" + a0 + ") = " + f8(a0));
                    System.out.println("f16(" + a0 + ") = " + f16(a0));
                    System.out.println("f32(" + a0 + ") = " + f32(a0));
                }
            } catch (Exception e) {
                System.out.println("Fel: Ej ett heltal > 0");
            }

        }

    }
    public static int iterLifeLength(int a0) {
        int c = 1;
        while (a0 != 1) {
            a0 = f1(a0);
            c++;
        } return c;
    }
    public static int iterateF(int a0, int n) {
        for (int i = 0; i <= n; i++) {
            a0 = f1(a0);
        }
        return a0;
    }

    public static int f1(int a0) {
        if (a0 == 1) {
            return 1;
        } else if (a0 % 2 == 0) {
            return a0/2;
        } else {
            return 3*a0 + 1;
        }
    }

    public static int f2(int a0) {
        return f1(f1(a0));
    }
    public static int f4(int a0) {
        return f2(f2(a0));
    }
    public static int f8(int a0) {
        return f4(f4(a0));
    }

    public static int f16(int a0) {
        return f8(f8(a0));
    }

    public static int f32(int a0) {
        return f16(f16(a0));
    }
}
