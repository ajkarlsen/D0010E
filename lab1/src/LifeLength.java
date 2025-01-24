import java.util.Scanner;

/* Task 7: Det hade lett till att programet hade loopat för alltid
Detta är pga att min funktion är rekursiv och kommer att fortsätta rekurreras tills att vi får a0 = 1.
Om vi aldrig får a0 = 1 komemr det att leda till att programmet fortsätter kalla på funktionen och aldrig slutar.

Det skulle alltså aldrig terminera
*/


//Task 5
// 1.   l(x) = l(f(x)) + 1, (x != 1)
// 2.   l(x) = 0,           (x == 1)



public class LifeLength {

    public static void main(String[] args) {
        int n = 2;

        switch (n) {
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 6: task6(); break;
            default: System.out.println("Invalid input");
        }
    }

    public static void task1() {
        Scanner scan = new Scanner(System.in);
        int a0;
        while (true) {
            try {
                System.out.print("Skriv in ett heltal större än 0: ");
                a0 = scan.nextInt();
                System.out.println("Du skrev in " + a0);

                if (a0 == 0) {
                    break;
                }

                System.out.println("f(" + a0 + ") = " + f1(a0));
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Fel: Ej ett heltal > 0");
            }
        }
        scan.close();
    }

    public static void task2() {
        Scanner scan = new Scanner(System.in);
        int a0;
        while (true) {
            try {
                System.out.print("Skriv in ett heltal större än 0: ");
                a0 = scan.nextInt();
                System.out.println("Du skrev in " + a0);
                if (a0 == 0) {
                    break;
                } else {
                    System.out.println("f(" + a0 + ")=" + f1(a0) + "    f2(" + a0 + ") = " + f2(a0) + "     f4(" + a0 + ") = " + f4(a0) + "     f8(" + a0 + ") = " + f8(a0) + "     f16(" + a0 + ") = " + f16(a0) + "   f32(" + a0 + ") = " + f32(a0));

                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Fel: Ej ett heltal > 0");
            }

        }
        scan.close();
    }

    public static int iterLifeLength(int a0) {
        int c = 0;
        while (a0 != 1) {
            a0 = f1(a0);
            c++;
        } return c;
    }

    public static String intsToString(int a0, int len) {
        return "The life length of " + a0 + " is " + len + ".";
    }


    public static void task3() {
        while (true) {
            int a0;
            int n;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("a0: ");
                a0 = scan.nextInt();
                if (a0 == 0) {
                    scan.close();
                    break;
                } else {
                    System.out.print("n: ");
                    n = scan.nextInt();
                    System.out.println(iterateF(a0, n));
                }

            }
            catch (Exception e) {
                System.out.println("Fel: Ej ett heltal > 0");
            }
        }
    }

    public static int iterateF(int a0, int n) {
        for (int i = 0; i < n; i++) {
            a0 = f1(a0);
        }
        return a0;
    }

    public static void task4() {

        for (int a0 = 1; a0 <= 15; a0++) {
            System.out.println(intsToString(a0, iterLifeLength(a0)));
        }
    }

    public static void task6() {
        for (int a0 = 1; a0 <= 15; a0++) {
            System.out.println("Lifelength for " + a0 + ": " + iterLifeLength(a0) + ", " + recLifeLength(a0));
        }
    }

    public static int recLifeLength(int a0) {
        if (a0 == 1) {
            return 0;
        } else {
            return iterLifeLength((f1(a0))) + 1;
        }
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
