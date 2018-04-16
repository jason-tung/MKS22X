import java.util.*;
@SuppressWarnings("unchecked")
public class Sorts{
	public static boolean print = true;

    public static void print(Object a){
		if (print) System.out.println(a);
    }

    public static void radixsort(MyLinkedListImproved<Integer> data){
		if (data.size() <= 0) return;
	    MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
		for (int i = 0; i < 10; i++){
		    buckets[i] = new MyLinkedListImproved<Integer>();
		}
		MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();
		MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
		for (Integer val : data){
		    if (val >= 0){
				pos.add(val);
		    }
		    else{
				neg.add(val * -1);
		    }
		}
		data.clear();
		minisort(pos, buckets);
		minisort(neg, buckets);

		for (Integer posints : pos){
			data.add(posints);
		}
		for (Integer negints : neg){
			data.add(0, negints * -1);
		}

    }
    public static void minisort(MyLinkedListImproved<Integer> part, MyLinkedListImproved<Integer>[] buckets){
	    	if (part.size() <= 0) return;
	    	for (MyLinkedListImproved wah : buckets){
	    		wah.clear();
	    	}
	    	//print(part);
	    	//print(part.max());
	    	//print(part.get(part.max()));
	    	int maxlen = (int) Math.ceil(Math.log10(part.get(part.max())));
	    	//print(maxlen);
	    	for (int i = 0; i < maxlen; i++){
	    		print("-------------------");
	    		for (Integer waaah : part){
	    			int holder = (int) ((waaah / Math.pow(10, i)) % 10);
	    			//print(waaah);
	    			//print(holder);
	    			buckets[holder].add(waaah);
	    			
	    		}
	    		print("----------");
	    		for (MyLinkedListImproved x : buckets) print(x);
	    			print("----------");
	    		//for (MyLinkedListImproved x : buckets) print(x);
	    			//print("-------");
	    		part.clear();

	    		for (MyLinkedListImproved bucket : buckets){
	    			//System.out.println(part == null);
	    			//System.out.println(bucket);
	    			
	    			print(bucket);
	    			part.extend(bucket);
	    			print(part);
	    			//print(bucket);
	    			//print(part);
	    			bucket.clear();
	    		}
	    		print("-------------------");
	    	}
	    	//for (MyLinkedListImproved x : buckets) print(x);
	    		print("--------");
	    		print (buckets.length);
	    	print(part);
	    	print("--------");
    }

      public static void main(String[] args){
      	MyLinkedListImproved<Integer> kevin = new MyLinkedListImproved<>();

		MyLinkedListImproved<Integer> wesley = new MyLinkedListImproved<>();

		for (int i = 0; i < 10; i++){
	 	   //kevin.add(i*10);
	  	  wesley.add((int) ((Math.random() * 100) - 100 * Math.random()));
		}
		//wesley.extend(kevin);
		print(wesley);
		radixsort(wesley);
		print(wesley);


    

    }



}
