import java.util.Scanner;
public class BubbleSort{
    public static void bubbleSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            boolean flag=false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag)
                break;            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Before Swapping : ");
        for(int elements : arr){
            System.out.print(elements+", ");
        }
        bubbleSort(arr);
        System.out.println("After Swapping : ");
        for(int elements : arr){
            System.out.print(elements+", ");
        }
    }
    
}
