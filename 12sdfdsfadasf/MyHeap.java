public class MyHeap{//<T extends Comparable<T>>{

//resize swap pU pD
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
    	pU(data.size);
    	size++;
    }

    public String remove(){
    	swap(0, size - 1);
    	size--;
    	pD(0);
    	return data[size];
    }

    public String peek(){
    	return data[0];
    }
    public int size(){
    	return size;
    }



}