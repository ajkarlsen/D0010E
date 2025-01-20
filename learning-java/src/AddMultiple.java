public class AddMultiple {
    public static void main(String[] args) {
        System.out.println(addMultiple(999));
    }
    static int addMultiple(int max) {
        int i = 1;
        int sum = 0;
        while (i <= max) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }
}
