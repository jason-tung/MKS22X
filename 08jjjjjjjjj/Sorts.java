import java.util.*;
@SuppressWarnings("unchecked")
public class Sorts{
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
		minisort(pos);
		minisort(neg);
		for (Integer posints : pos){
			data.add(posints);
		}
		for (Integer negints : neg){
			data.add(0, negints * -1);
		}

    }
    public static void minisort(MyLinkedListImproved<Integer> part){
	    	if (data.size() <= 0) return;
	    	for (MyLinkedListImproved wah : buckets){
	    		wah.clear();
	    	}
	    	int maxlen = (int) math.floor(math.log10(part.max()));
	    	for (int i = 0; i < maxlen; i++){
	    		for (Integer waaah : part){
	    			int holder = (int) ((waaah / math.pow(10, i)) % 10);
	    			buckets[holder].add(waaah);
	    		}
	    		part.clear();
	    		for (MyLinkedListImproved bucket : buckets){
	    			part.extend(bucket);
	    			bucket.clear();
	    		}
	    	}
    	}


}
