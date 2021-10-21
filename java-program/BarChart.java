public class BarChart {

	public static void main(String[] args) {
		
		int[] arr = {3, 4, 0, 7};
		
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(int row=max; row>0; row--) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] >= row)
					System.out.print("*\t");
				else
					System.out.print(" \t");
			}
			System.out.println();
		}

	}

}
