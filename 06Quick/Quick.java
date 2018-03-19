import java.util.*;
public class Quick{

	public static void main(String[] ary){
		int[] data = {4, -10, 18, 6, 16, -8, 3, -1, 9, -12};

		

	quicksort(data);

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
		//n--;
		int start = 0;
		int end = data.length-1;
		int[] ans = partition(data, start, end);
		int lowbound = ans[0];
		int upbound = ans[1];
		//System.out.println(Arrays.toString(data));
		//System.out.println(Arrays.toString(ans));
		while (!(n>= lowbound && n < upbound)){
			if (n < lowbound){
				end = lowbound - 1;
			}
			else{
				start = upbound;
			}
		    ans = partition(data, start, end);
			lowbound = ans[0];
		    upbound = ans[1];
		    //System.out.println(Arrays.toString(ans));
		}
		
		return data[lowbound];
	}

	public static void quicksort(int[] data){
		quicksort(data, 0, data.length-1);
	}

	public static void quicksort(int[] data, int start, int end){
		if (start < end){
			//System.out.println("passed");
			int[] ans = partition(data, start, end);
			//System.out.println(Arrays.toString(data));
			//System.out.println(Arrays.toString(ans));
			quicksort(data, start, ans[0] - 1);
			quicksort(data, ans[1], end);
		}
	}

	

	public static void swap(int[] ary, int a, int b){
		int dog = ary[a];
		ary[a] = ary[b];
		ary[b] = dog;
	}
}
