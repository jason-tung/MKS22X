import java.util.*;

public class Merge{
    //will fix later
    public static void merge(int[] data, int[] temp, int start1, int end1, int start2, int end2){
		for (int i = start1; i <= end2; i++){
		    //System.out.println(Arrays.toString(data));
		    //System.out.println(start1 + " " + start2 + " " + end2);
		    ///System.out.println(temp[start1]);
		    //System.out.println(temp[start2]);
		    //System.out.println("\n");
		    if (start1 <= end1  && ( start2 > end2 || temp[start1] <= temp[start2] )){
				data[i] = temp[start1];
				start1++;
		    }
		    else{
				data[i] = temp[start2];
				start2++;
		    }
		}
    }

    public static void mergesort(int[] data){
		int[] temp = new int[data.length];
		mergesort(data, temp, 0, data.length-1);
    }

    public static void mergesort(int[] data, int[] temp, int start, int end){
    	if (start < end){
    		int partition = (start + end)/2;

    		for (int i = start; i <= end; i++){
          		temp[i] = data[i];
        	}
        	//System.out.println(Arrays.toString(data));
        	//System.out.println(start + " " + partition + " " + end);
        	//System.out.println(Arrays.toString(temp));
    		mergesort(temp, data, start, partition);
    		mergesort(temp, data, partition + 1, end);
    		merge(data,temp, start, partition, partition + 1, end);
    	}

    }

    public static void main (String[] args){
    	
	int[] a = {9,8,7,6,5,4,3,2,1,0};
		/*
		int[] b = new int[a.length];
		merge(b, a, 0, 2,3, 5);
		System.out.println();
		System.out.print(Arrays.toString(b));
		System.out.println("\n");
		*/
	        insertionsort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
    }

    public static void insertionsort(int[] data, int low, int high){
	for(int dog = low + 1; dog <= high; dog++){
	    //System.out.println(Arrays.toString(data));
	    int temp = dog;
	    //System.out.println(dog + " " + temp);
	    while(temp - 1 >= low && data[dog] < data[temp - 1]){
		//System.out.println(data[temp - 1] + " " + data[temp]);
		temp--;		
		
	    }
	    if (temp != dog){
		swap(data, temp, dog);
	    }
	}
    }
	    
    public static void swap(int[] ary, int a, int b){
	int dog = ary[a];
	ary[a] = ary[b];
	ary[b] = dog;
    }
}
