import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {12,2,5,8,1};
        System.out.println("Unsorted-> "+Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted-> "+Arrays.toString(arr));

    }
    public static void quickSort(int[] arr,int lower,int upper)
    {
        if(lower >= upper)
        {
            return;
        }
            int pivotI = partition(arr,lower,upper);
            quickSort(arr,lower,pivotI-1);
            quickSort(arr,pivotI+1,upper);
    }

    private static int partition(int[] arr, int lower, int upper) {
        int pivot = arr[lower];
        int down = lower;
        int up = upper;
        while(down < up)
        {
            while( down< arr.length-1 && arr[down] <= pivot)
            {
                down = down + 1;
            }
            while(up>=0 && arr[up] > pivot)
            {
                up = up - 1;
            }
            if(down < up)
            {
                int temp = arr[down];
                arr[down] =  arr[up];
                arr[up] = temp;
            }
        }
        arr[lower]  = arr[up];
        arr[up]  = pivot;
        return up;
    }
}
