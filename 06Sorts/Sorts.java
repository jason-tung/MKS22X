import java.util.*;
public class Sorts{

	public static void main(String[] ary){
		int[] data = {5,3,7,5,34,3,765};

		System.out.println(partition(data, 0, data.length-1));

	}

	public static int partition (int[] data, int start, int end){
		int piv = data[start + (int) (Math.random() * (end - start))];
		int wall = 0;
		while (start != end){
			System.out.println("pivot: " + piv);
			if (data[start] <= piv){
				swap(data, start, wall);
				wall++; start++;
			}
			else{
				swap(data, end, wall);
				end--;
			}
			System.out.println(Arrays.toString(data));
			System.out.println("\n");
		}
		return start;

	}

	

	public static void swap(int[] ary, int a, int b){
		int dog = ary[a];
		ary[a] = ary[b];
		ary[b] = dog;
	}
}