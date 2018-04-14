@SuppressWarnings("unchecked")
public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size() == 0) return;
        MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	for (int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved();
	}
	MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
	int negreps;
	int posreps;
	for (Node node : data){
	    int val = node.getValue();
	    if (val < 0){
		neg.add(node);
	    }
	    else{
		pos.add(node);
	    }
	}
	for (Node node: pos){
	    int holder = (int) Math.floor(Math.log10(node.getValue()));
	    if (posreps < holder){
		posreps = holder;
	    }
	}
	for (Node node: neg){
	    int holder = (int) Math.floor(Math.log10(-1 * node.getValue()));
	    if (negreps < holder){
		negreps = holder;
	    }
	}
    }
}
