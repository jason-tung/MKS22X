 import java.util.*;

public class RunningMedian{
    public MyHeap<Double> smallHeap;
    public MyHeap<Double> bigHeap;
    public static void main(String[] str){
	
    }
    public RunningMedian(){
	smallHeap = new MyHeap<>();
	bigHeap = new MyHeap<>(false);
    }

    public void add(Double a){
	if (smallHeap.size() <= bigHeap.size()){
	    smallHeap.add(a);
	}
	else{
	    bigHeap.add(a);
	}
	if (smallHeap.size() - bigHeap.size() > 1) bigHeap.add(smallHeap.remove());
	else if (smallHeap.size() - bigHeap.size() < -1) smallHeap.add(bigHeap.remove());
	
    }

    public double getMedian(){
	if (smallHeap.size() > bigHeap.size()) return smallHeap.peek();
	if (bigHeap.size() > smallHeap.size()) return bigHeap.peek();
	return (smallHeap.peek() + bigHeap.peek()) / 2
    }
    
}

/*
  RunningMedian.java
  -RunningMedian() - makes an empty container for Doubles.
  -void add(Double) - insert a Double into the data structure.
  -Double getMedian() - return the current median, throws NoSuchElementException when size is 0.
  -int size()
    */

