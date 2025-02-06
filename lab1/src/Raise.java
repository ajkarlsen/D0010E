public class Raise {
    public static int c1 = 0;
    public static int c2 = 0;

    /* Task 10
    Storleken på k kommer att påverka mest då det är pga den som funktionen rekurreras såpass många gånger.
    Den ska alltid ner till 0, antingen genom att halveras eller ta -1 på så desto större den är desto längre
    tid kommer funktionen att ta. Storleken på x har ingen betydelse då det där bara är en multiplikation
    */

    //Recraiseone
    //Vi ser relativt tydligt att denna kommer att representeras av en rät linje
    //Detta är tydligt då den alltid tar -1 och kommer således alltid att få k stycker rekursioner
    // N(k) = k + 1, +1 är för att vi börjar med 0

    //Recraisehalf
    //Här inser vi att vi kommer att få en logaritmisk mängd rekursioner
    //Detta är då den konstant delas med två och vi får alltså en betydligt snabbare algoritm
    //Ser ut exakt som N(k) = (log2(k) + 1) ceiling

    public static void main(String[] args) {

        System.out.println("Använder recRaiseOne:");
        for (int i = 1; i <= 15; i++) {
            System.out.println("1.5^" + i + "=" + recRaiseOne(1.5, i) + ", Antal rekursioner = " + c1);
            c1 = 0;
        }
        System.out.println("Använder recRaiseHalf:");
        for (int i = 1; i <= 15; i++) {
            System.out.println("1.5^" + i + "=" + recRaiseHalf(1.5, i) + ", Antal rekursioner = " + c2);
            c2 = 0;
        }
/*
        for (int i = 0; i <= 10000; i++) {
            c1 = 0;
            recRaiseOne(1.0005, i);
            System.out.println(i + ":" + c1);
        }
        for (int i = 0; i <= 10000; i++) {
            c2 = 0;
            recRaiseHalf(1.0005, i);
            System.out.println(i + ":" + c2);
        }*/
    }



    public static double recRaiseOne(double x, int k) {
        c1++;
        if (k == 0) {
            return 1;
        } else {
            return x * recRaiseOne(x, k-1);
        }
    }


    public static double recRaiseHalf(double x, int k) {
        c2++;
        if (k == 0) {
            return 1;
        } else if (k % 2 == 0) {
            double var = recRaiseHalf(x, k / 2);
            return var*var;
        } else {
            double var = recRaiseHalf(x, k / 2);
            return x * var * var;
        }
    }


}

