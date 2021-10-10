import java.util.Arrays;

public class mergesort {
 public static void  mergesort(int[] arr, int l, int r){
      if(l<r){
         int  mid=(l+r)/2;
         mergesort(arr,l,mid);
         mergesort(arr,mid+1,r);
         merge(arr,l,mid,r);


      }

  }
    private static void merge(int[] arr, int l,int mid,int r){
     int arr1[]=new int[r+1];
     int i=l;
     int j=mid+1;
     int k=l;
     while(i<=mid && j<=r){
         if(arr[i]<arr[j]){
             arr1[k]=arr[i];
             i++;
         }
         else{
             arr1[k]=arr[j];
             j++;
         }
         k++;
     }
     if(i>mid){
         while(j<=r){
             arr1[k]=arr[j];
             k++;
             j++;
         }
     }
     else{
         while(i<=mid){
             arr1[k]=arr[i];
             k++;
             i++;
         }
     }
      for (k = l; k <=r ; k++) {
          arr[k]=arr1[k];
          
      }
  }

    public static void main(String[] args) {
        int arr[]={1,45,223,67,89};
        mergesort(arr,0, arr.length-1);
      //  System.out.println(Arrays.toString(arr));
        //or
        for (int i = 0; i <arr.length ; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
    }
}
