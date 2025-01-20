public class WriteNumber {
    public static void main(String[] args) {
        writeNumber(14);
    }

    static void writeNumber(int number) {
        switch (number) {
            case 0: System.out.println("zero");
            case 1: System.out.println("one");
            case 2: System.out.println("two");
            case 3: System.out.println("three"); break;
            case 4: System.out.println("four"); break;
            case 5: System.out.println("five"); break;
            case 6: System.out.println("six"); break;
            case 7: System.out.println("seven"); break;
            case 8: System.out.println("eight"); break;
            case 9: System.out.println("nine"); break;
            default: System.out.println("invalid number"); break;
        }
    }
}

