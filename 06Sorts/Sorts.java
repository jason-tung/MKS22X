import java.util.*;
public class Sorts{

	public static void main(String[] ary){
		int[] data = {6,5,4,3,2,1,0};

		System.out.println(partition(data, 0, 6));

	}

	public static int partition (int[] data, int start, int end){
		int piv = data[start + (int) (Math.random() * (end - start))];
		while (start != end){
			System.out.println("pivot " + piv);
			if (data[start] >= piv){
				if (data[end] < piv){
					swap(data,start,end);
					start++;
				}
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