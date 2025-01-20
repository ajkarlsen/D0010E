public class Såg {
    public static void main(String[] args) {
        triangle(4);
        //sågtand(16, 3);
    }

    static void triangle(int a) {
        for (int i = 1; i <= a; i++) {
            for (int j=0; j<i; j++) {
                if (j == i-1) {
                    System.out.print("\\");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println(" ");
        }
    }

    static void sågtand(int a, int b) {
        for (int i = 1; i <= b; i++) {
            triangle(a);
        }
    }
}
