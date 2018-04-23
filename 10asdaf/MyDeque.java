import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    public static boolean print = false;

    public static void print(Object a){
        if (print) System.out.println(a);
    }

    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	   data = (E[]) new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    
    public MyDeque(int AAAAAAAAAAAAAAAAA){
    	if(AAAAAAAAAAAAAAAAA < 0) throw new IllegalArgumentException();
    	data = (E[]) new Object[AAAAAAAAAAAAAAAAA];
    }

    
    public String toString1(){
        String str = "[";
        for (int i = 0; i < size; i++){
            str += data[(start + 1)%data.length] + ",";
        }
        if (size != 0) str = str.substring(0,size - 1);
        return str + "]";

    }

    public int size(){
	   return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	   E[] ary = (E[]) new Object[2 * size];
       for (int i = 0; i < size; i++){
            ary[i] = data[(start + 1)%data.length];
       }
       data = ary;
       start =0; 
       end = size - 1;
    }

    
    public void addFirst(E element){
        check(0);
        if (element == null) throw new NullPointerException();
    	start = Math.floorMod(start - 1, data.length);
        data[start] = element;
        size++;
    }

    public void addLast(E element){
        check(0);
        if (element == null) throw new NullPointerException();
        end = (end + 1) % data.length;
        data[end] = element;
        size++;
    }

    public E removeFirst(){
        check(1);
        E kevin = data[start];
        start = (start + 1) % data.length;
        size--;
        return kevin;
    }

    public E removeLast(){
        check(1);
        E kevin = data[end];
        end = Math.floorMod(end - 1, data.length);
        size--;
        return kevin;
    }

    public E getFirst(){
        check(1);
        return data[start];
    }

    public E getLast(){
        check(1);
        return data[end];
    }

    public void check(int a){
        switch (a){
            case 1:
                if (size == 0) throw new NoSuchElementException();
                break;
            case 0:
                if (size == data.length) resize();
                break;
        }
    }
        

    /**-----------------------------------------------------------------------------------------------------------------------------------------------------------**/

    public static void main(String[] args){
        crystalDriver(args);
    }
    public String toString(){
    String ans = "[";
    if(start < end){
      for (int i = start; i <= end; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= end; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

  public static void crystalDriver(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
}
