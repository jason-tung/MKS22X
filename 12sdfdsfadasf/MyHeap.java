import java.util.*;

public class MyHeap{//<T extends Comparable<T>>{

//resize swap up down
	public static boolean print = false;

    public static void print(Object a){
        if (print) System.out.println(a);
    }

    private int size;
    private String[] data;
    private boolean typeMax;

    public MyHeap(){
    	this(true);
    }

    public MyHeap(boolean wdog){
    	typeMax = wdog;
    	data = new String[10];
    	//data = (T[]) new Comparable[10];
        size = 0;
    }

    public void add(String s){
    	if (size == data.length) resize();
    	data[size] = s;
    	up(size);
    	size++;
    }

    public String remove(){
    	swap(0, size - 1);
    	size--;
    	down(0);
    	return data[size];
    }

    public String peek(){
    	return data[0];
    }
    public int size(){
    	return size;
    }

    public void pushUp(int index){
    	int yeehaw = data[index].compareTo(data[(index-1)/2]);
    	if (typeMax && yeehaw > 0 || !typeMax && yeehaw < 0){
    		swap(index, (index - 1) / 2);
    		up((index - 1) / 2);
    	}  
    }

    public void pushDown(int index){
    	int left = index * 2 + 1;
    	int right = left + 1;
    	if (typeMax){
    		if (inBounds(left) && lessThan(index,left,data) && (!inBounds(right) || greaterThan(left,right,data))){
    			swap(index, left);
    			down(left);
    		}
    		else if(inBounds(right) && lessThan(index,right,data) && (!inBounds(left) || greaterThan(right,left,data))){
    			swap(index, right);
    			down(right);
    		}
    	}
    	else{
    		if (inBounds(left) && greaterThan(index,left,data) && (!inBounds(right) || lessThan(left,right,data))){
    			swap(index, left);
    			down(left);
    		}
    		else if(inBounds(right) && greaterThan(index,right,data) && (!inBounds(left) || lessThan(right,left,data))){
    			swap(index, right);
    			down(right);
    		}
    	}

    }

    public boolean inBounds(int index){
    	return index < size;
    }

    public boolean greaterThan(int a, int b, String[] data){
    	return data[a].compareTo(data[b]) > 0;
    }

    public boolean lessThan(int a, int b, String[] data){
    	return data[a].compareTo(data[b]) < 0;
    }

    public void resize(){
        String[] asdf = new String[2 * size];
		for (int i = 0; i < size; i++){
	    	asdf[i] = data[i];
		}
        data = asdf;	
    }

    public void swap (int a, int b){
		String qqq = data[a];
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






}