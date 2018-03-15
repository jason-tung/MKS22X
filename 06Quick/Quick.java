import java.util.*;
public class Quick{

	public static void main(String[] ary){
		int[] data = {2, 8, 4, 6, 10, 0};

		quicksort(data);

	System.out.println(Arrays.toString(data));

	}

	public static int partition (int[] data, int start, int end){
		int pindex = start + (int) (Math.random() * (end - start));
		int pivot = data[pindex];
		int realStart = start;

		//System.out.println(pivot);

		swap(data, pindex, start);
		start++;

		while(start <= end){
			//System.out.println (pivot);
	    	//System.out.println (Arrays.toString(data));
			if (data[start] < pivot) start++;
			else{
				swap(data, start, end);
				end--;
			}
		}
		swap(data, realStart, end);
		//System.out.println(Arrays.toString(data));

		return end;
		

	}

	public static int quickselect(int[] data, int n){
		int start = 0;
		int end = data.length-1;
		int ans = partition(data, start, end);
		while (ans != n){
			ans = partition(data, ans + 1, end);
			if (ans > n) ans = partition(data, start, ans - 1);
		}
		return data[ans];
	}

	public static void quicksort(int[] data){
		quicksort(data, 0, data.length-1);
	}

	public static void quicksort(int[] data, int start, int end){
		if (start != end){
		int dog = partition(data, start, end);
		
			partition(data, start, dog - 1);
		 	partition(data, dog + 1, end);
	}}

	

	public static void swap(int[] ary, int a, int b){
		int dog = ary[a];
		ary[a] = ary[b];
		ary[b] = dog;
	}
}