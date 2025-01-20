public class Area {
    public static void main(String[] args) {
        System.out.println(area(3,2,3));
    }
    static double area(double a, double b, double c) {


        if (!RiktigTriangel.riktigTriangel(a, b, c)) {

            throw new
                    IllegalArgumentException("Ej sidor på triangel");
        }
        double s = (a + b + c)/2;
        return Math.sqrt(s * (s-a)*(s-b)*(s-c));
    }
}
