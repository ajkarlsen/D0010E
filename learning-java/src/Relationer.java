public class Relationer {
    public static void main(String[] args) {
        System.out.println(isThreeEqual(12, 12, 10));
    }
    static boolean isThreeEqual(int a, int b, int c) {
        return (a == b) && (a == c);
    }
}
