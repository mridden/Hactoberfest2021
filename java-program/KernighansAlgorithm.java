import java.util.*;
public class KernighansAlgorithm {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 0;
        while(n != 0){
            int rsbm = n & -n;
            n = n - rsbm;
            count++;
        }
        System.out.println(count);
    
	}
}
