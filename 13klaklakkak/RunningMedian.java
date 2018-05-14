 import java.util.*;
 
public class RunningMedian{
    public MyHeap<Double> smallHeap;
    public MyHeap<Double> bigHeap;

    public RunningMedian(){
	smallHeap = new MyHeap<>();
	bigHeap = new MyHeap<>(false);
    }

    public void add(Double a){
      if (smallHeap.size() == 0 && bigHeap.size() ==0) smallHeap.add(a);
      else{
        if (a > smallHeap.peek()){
          bigHeap.add(a);
          if (bigHeap.size() - smallHeap.size() > 1) smallHeap.add(bigHeap.remove());
        }
        else{
          smallHeap.add(a);
          if (smallHeap.size() - bigHeap.size() > 1) bigHeap.add(smallHeap.remove());
        }
      }
    }

    public double getMedian(){
	if (smallHeap.size() > bigHeap.size()) return smallHeap.peek();
	if (bigHeap.size() > smallHeap.size()) return bigHeap.peek();
	return (smallHeap.peek() + bigHeap.peek()) / 2;
    }

    public static void main(String[] args){
      RunningMedian kevin = new RunningMedian();
      ArrayList<Double> wesley = new ArrayList<>();
      double[] list = {2,4,6,2,7,2,4,6,3.2,76.46,83.2,7.2, 3.2, 4.5, 5.5,3.2,6.7};
      //double[] list = {0,1,2,3,4,5,6,7,8,9,10};
      for (double x: list){
        test(kevin, wesley, x);
      }
    } 

    public String toString(){
      return "[" + smallHeap.toString() + "] " + "[" + bigHeap + "]";
    }

    public static void test(RunningMedian k, ArrayList<Double> w, double num){
      System.out.println("adding: " + num);
      k.add(num);
      System.out.println("kevin " + k);
      w.add(num);
      Collections.sort(w);
      System.out.println("wesley: "  + w);
      String ans = "" + w.get(w.size() / 2);
      if (w.size() != 0 && w.size() % 2 == 0){
        ans =  "" + (w.get((w.size() - 1)/2 ) + w.get(w.size()/2)) / 2;
      }
      System.out.println("kevin-med: " + k.getMedian() + " wesley-med: " + ans);
      System.out.println();
  }    
}

/*
  RunningMedian.java
  -RunningMedian() - makes an empty container for Doubles.
  -void add(Double) - insert a Double into the data structure.
  -Double getMedian() - return the current median, throws NoSuchElementException when size is 0.
  -int size()
    */

