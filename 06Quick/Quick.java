import java.util.*;
public class Quick{

	public static void main(String[] ary){
		int[] data = {5,3,7,6,34,3,765,865,23,567};

		System.out.println(partition(data, 0, data.length-1));

	}

	public static int partition (int[] data, int start, int end){
		int pivot = start + (int) (Math.random() * (end - start));
		int piv = data[pivot];
		while (start != end){
			System.out.println(data[start] + " " + data[end]);
			System.out.println("pivot: " + piv);
			if (data[start] >= piv){
				swap(data, start, end);
				end--;
			}
			else{
				start++;

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