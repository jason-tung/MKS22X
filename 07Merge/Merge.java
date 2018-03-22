public class Merge{
    //will fix later
    public static void merge(int[] data, int[] temp, int start, int mid, int end){
	for (int i = start; i <= end; i++){
	    if (start <= middle && (temp[start] >= temp[end] || end <= mid)){
		data[i] = temp[start];
		start++;
	    }
	    else{
		data[i] = temp[end];
		end--;
	    }
	}
    }
}
