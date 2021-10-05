import java.util.Scanner;

class year {
    public static void main(String[] args) {
        int y;
        System.out.println("Enter a year : ");
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();   //To input a year from user

        if ((y % 100 == 0) && (y % 400 == 0) || (y % 100 != 0) && (y % 4 == 0)) {
            System.out.print("YES!! Entered Year is a Leap year");
        } else {
            System.out.print("NO!! Entered Year is not a Leap year");
        }
    }
}
