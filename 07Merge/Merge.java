import java.util.*;

public class Merge{
    //will fix later
    public static void merge(int[] data, int[] temp, int start1, int end1, int start2, int end2){
	for (int i = start1; i <= end2; i++){
	    System.out.println(Arrays.toString(data));
	    System.out.println(temp[start1]);
	    System.out.println(temp[start2]);
	    if (start1 <= end1  && (temp[start1] >= temp[start2] || start2 > end2)){
		data[i] = temp[start1];
		start1++;
	    }
	    else{
		data[i] = temp[start2];
		start2++;
	    }
	}
    }

    public static void merge(int[] data){
	int[] temp = new int[data.length];
	merge(data, temp, 0, data.length-1);
    }

    public static void merge

    public static void main (String[] args){
	int[] a = {5,4,3,6,2,1,7,3,6,8};
	int[] b = new int[a.length];
	merge(b, a, 0, 2,3, 5);
	System.out.println();
	System.out.print(Arrays.toString(b));
	System.out.println("\n");
    }
}
