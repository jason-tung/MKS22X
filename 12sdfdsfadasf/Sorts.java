import java.util.*;

public class Sorts{
    public static void main(String[] str){
	int[] asdf = {5,34,26,2,7,9,4,0,4,2,4,5,7};
        heapsort(asdf);
	System.out.println(Arrays.toString(asdf));
	
    }

    public static void heapsort(int[] data){
	heapify(data);
	//System.out.println(Arrays.toString(data));
	for (int i = data.length - 1; i > 0; i--){
	    swap(0, i, data);
	    //System.out.println(i + " " + Arrays.toString(data));
	    pushDown(0, data, i - 1); //the problem is the push down; you need to add a second parameter to limit how far you can push it
	    //System.out.println(i + " " + Arrays.toString(data));
	}
    }
    
    public static void heapify(int[]data){
	for (int i = 0; i < data.length; i++){
	    pushDown(i, data, data.length - 1);
	}	
    }

    public static void pushDown(int index, int[] data, int limit){
    	int left = index * 2 + 1;
    	int right = left + 1;
	// if (data[index] == 4){
	//     System.out.println("AAAAAAAAAAAAAAAAAAAAA");
	// }
	if (inBounds(left, limit) && lessThan(index,left,data) && (!inBounds(right, limit) || greaterThan(left,right,data))){
	    swap(index, left, data);
	    pushDown(left, data, limit);
	}
	else if(inBounds(right, limit) && lessThan(index,right,data) && (!inBounds(left, limit) || greaterThan(right,left,data))){
	    swap(index, right, data);
	    pushDown(right, data, limit);
	}
	// else if (data[index] == 4){
	//     if (inBounds(left, limit) && lessThan(index,left,data) && (!inBounds(right, limit) || greaterThan(left,right,data))){
	//     }
	//     if (inBounds(left, limit) && lessThan(index,left,data)){
	// 	System.out.println("DFSFD");
	//     }
	// }
    

    }
    public static boolean inBounds(int index, int limit){
    	return index <= limit && index >= 0;
    }

    public static boolean greaterThan(int a, int b, int[] data){
    	return data[a] >= data[b];
    }

    public static boolean lessThan(int a, int b, int[] data){
    	return data[a] <= data[b];
    }

    public static void swap (int a, int b, int[] data){
	int qqq = data[a];
	data[a] = data[b];
	data[b] = qqq;
    }
}
