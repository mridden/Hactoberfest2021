import java.util.Scanner;

class year {
    public static void main(String[] args) {
        int y;
        System.out.println("Enter a year");
        Scanner r = new Scanner(System.in);
        y = r.nextInt();

        if (y % 100 == 0 && y % 400 == 0 || y % 100 != 0 && y % 4 == 0) {
            System.out.print("Leap year");
        } else {
            System.out.print("Not a leap year");
        }
    }
}