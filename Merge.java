public class Merge{

	public static void merge(int[] data, int start, int middle, int end){
		int[] lhs = new int[middle-start];
		int[] rhs = new int[end-middle+1];
		int lincr = 0;
		int rincr = 0;
		for (int i = start; i <= end; i++){
			if (i < middle && lincr < lhs.length){
				lhs[lincr] = data[i];
				lincr++;
			}
			else{
				rhs[rincr] = data[i];
				rincr++;
			}
		}
		lincr = 0;
		rincr = 0;
		for (int i = start; i <= end; i++){
			if (lhs[lincr] < rhs[rincr] && lincr < lhs.length){
				data[i] = lhs[lincr];
				lincr++;
			}
			else{
				data[i] = rhs[rincr];
				rincr++;
			}
		}
	}
}