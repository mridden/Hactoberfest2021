import java.util.Scanner;

public class AnyBaseToAnyBase {
    // To convert to any base to any base, we must first convert to decimal from
    // first base, then decimal to second base.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        System.out.println(n + " in base " + b1 + " = " + anyBaseToAnyBase(n, b1, b2) + " in base " + b2);

        scn.close();
    }

    // any base to decimal (for converting b1 to decimal)
    public static int anyBaseToDecimal(int n, int b) {
        int ans = 0;
        int pb = 1; // powers of base
        while (n != 0) {
            int rem = n % 10;
            ans = ans + (rem * pb);
            n = n / 10;
            pb = pb * b;
        }
        return ans;
    }

    // decimal to any base (to convert decimal to b2)
    public static int decimalToAnyBase(int n, int b) {
        int ans = 0;
        int tp = 1; // powers of 10
        while (n != 0) {
            int rem = n % b;
            ans = ans + (rem * tp);
            n = n / b;
            tp = tp * 10;
        }

        return ans;
    }

    public static int anyBaseToAnyBase(int n, int b1, int b2) {

        int ans = 0;
        int nb1 = anyBaseToDecimal(n, b1);
        ans = decimalToAnyBase(nb1, b2);
        return ans;

    }
}