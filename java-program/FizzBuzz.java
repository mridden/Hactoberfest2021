public class FizzBuzz {
    public static void main(String[] args) {
        // Loop from 1 to 100
        for (int i = 1; i <= 100; i++) {
            // Check if the number is divisible by 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz"); // If divisible by both 3 and 5, print "FizzBuzz"
            } else if (i % 3 == 0) {
                System.out.println("Fizz"); // If divisible by 3, print "Fizz"
            } else if (i % 5 == 0) {
                System.out.println("Buzz"); // If divisible by 5, print "Buzz"
            } else {
                System.out.println(i); // If not divisible by 3 or 5, print the number itself
            }
        }
    }
}
