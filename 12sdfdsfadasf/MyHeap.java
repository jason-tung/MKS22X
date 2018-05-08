import java.util.*;

public class MyHeap <T extends Comparable <T>>{//<T extends Comparable<T>>{

//resize swap up down
    public static boolean print = false;

    public static void print(Object a){
        if (print) System.out.println(a);
    }

    private int size;
    private T[] data;
    private boolean typeMax;

    public MyHeap(){
    	this(true);
    }

     @SuppressWarnings("unchecked")
    public MyHeap(boolean wdog){
    	typeMax = wdog;
    	data = (T[])new Comparable[10];
    	//data = (T[]) new Comparable[10];
        size = 0;
    }

     @SuppressWarnings("unchecked")
     

    public void add(T s){
    	if (size == data.length) resize();
    	data[size] = s;
    	pushUp(size);
    	size++;
    }

    public T remove(){
    	swap(0, size - 1);
    	size--;
    	pushDown(0);
    	return data[size];
    }

    public T peek(){
    	return data[0];
    }
    public int size(){
    	return size;
	
    }

    public void pushUp(int index){
    	int yeehaw = data[index].compareTo(data[(index-1)/2]);
    	if (typeMax && yeehaw > 0 || !typeMax && yeehaw < 0){
    		swap(index, (index - 1) / 2);
    		pushUp((index - 1) / 2);
    	}  
    }

    public void pushDown(int index){
    	int left = index * 2 + 1;
    	int right = left + 1;
    	if (typeMax){
    		if (inBounds(left) && lessThan(index,left,data) && (!inBounds(right) || greaterThan(left,right,data))){
    			swap(index, left);
    			pushDown(left);
    		}
    		else if(inBounds(right) && lessThan(index,right,data) && (!inBounds(left) || greaterThan(right,left,data))){
    			swap(index, right);
    			pushDown(right);
    		}
    	}
    	else{
    		if (inBounds(left) && greaterThan(index,left,data) && (!inBounds(right) || lessThan(left,right,data))){
    			swap(index, left);
    			pushDown(left);
    		}
    		else if(inBounds(right) && greaterThan(index,right,data) && (!inBounds(left) || lessThan(right,left,data))){
    			swap(index, right);
    			pushDown(right);
    		}
    	}

    }

    public boolean inBounds(int index){
    	return index < size;
    }

    public boolean greaterThan(int a, int b, T[] data){
    	return data[a].compareTo(data[b]) > 0;
    }

    public boolean lessThan(int a, int b, T[] data){
    	return data[a].compareTo(data[b]) < 0;
    }

     @SuppressWarnings("unchecked")
    public void resize(){
        T[] asdf = (T[]) new Comparable[2 * size];
		for (int i = 0; i < size; i++){
	    	asdf[i] = data[i];
		}
        data = asdf;	
    }

    public void swap (int a, int b){
		T qqq = data[a];
		data[a] = data[b];
		data[b] = qqq;
    }

    public String toString(){
    	String str = "";
    	for (int i = 0; i < size; i ++){
    		str += data[i] + " ";
    	}
    	return str;
    }


    public static void main(String[] args){
	MyHeap kevin = new MyHeap();
	for (int i = 0; i < 10; i++){
	    kevin.add(i);
	    print(kevin);
	}
    }



}
