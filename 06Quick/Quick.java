import java.util.*;
public class Quick{

	public static void main(String[] ary){
		int[] data = {2, 8, 4, 6, 10, 0};

		quicksort(data);

	System.out.println(Arrays.toString(data));

	}

	public static int[] partition (int[] data, int start, int end){
		int pindex = start + (int) (Math.random() * (end - start));
		int pivot = data[pindex];
	        int lo = start;
		int hi = end;
		int lt = start;
		int i = start;
		int gt = end;

		while (gt >= i){
		    if(data[i] == pivot){
			i++;
		    }
		    else if (data[i] > pivot){
			swap(data,i, gt);
			gt--;
		    }
		    else{
			swap(data,i,lt);
			lt++;
			i++;
		    }
		}
		int[] a = {lt, i};
		return a;
		
	}

	public static int quickselect(int[] data, int n){
		int start = 0;
		int end = data.length-1;
		int[] ans = partition(data, start, end);
		int lowbound = ans[0];
		int upbound = ans[1];
		while (n < lowbound && n >= upbound){
		    ans = partition(data, start, lt);
		    lowbound = ans[0];
		    upbound = ans[1];
		    lowbound = partition(data,start,end)[0];
		    upbound = 
			if (ans > n) ans = partition(data,start,end)[1];
		}
		return data[lowbound];
	}

	public static void quicksort(int[] data){
		quicksort(data, 0, data.length-1);
	}

	public static void quicksort(int[] data, int start, int end){
		if (start != end){
		int dog = partition(data, start, end);
		
			partition(data, start, dog - 1);
		 	partition(data, dog + 1, end);
		}
	}

	

	public static void swap(int[] ary, int a, int b){
		int dog = ary[a];
		ary[a] = ary[b];
		ary[b] = dog;
	}
}
