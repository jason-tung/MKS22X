

import java.util.LinkedList;import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

    private Node first,last;
    private int size;

    public static boolean print = true;

    public static void print(Object a){
		if (print) System.out.println(a);
    }

    private Node getNode(int index){
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    	Node current = first;
    	for (int i = 0; i < index; i++) current = current.getNext();
    	return current;
    }

    public void clear(){
      first = null;
	   last = null;
	   size = 0;
    }

    public int size(){
	   return size;
    }

    public T get(int index){
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    	return getNode(index).getValue();
    }

    public T set(int index, T value){
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    	Node kevin = getNode(index);
    	kevin.setValue(value);
    	return kevin.getValue();
    }

    public int indexOf(T val){
    	Node current = first;
    	for (int i = 0; i <= size; i++){
    	    if (current.getValue().equals(val)) return i;
    	    if (i < size - 1) current = current.getNext();
    	}
    	return -1;
    }

    public boolean add(T value){
    	if (size == 0){
    		first = new Node(value);
		  last = first;
    	}
        else{
    	    Node newNode = new Node(value);
    	    newNode.setPrev(last);
    	    last.setNext(newNode);
    	    last = newNode;
	    }
	       //	System.out.println(newNode.getPrev() + " "+ newNode + " "  + newNode.getNext() + " " + value);
	    size++;
        return true;
    }

    public void add(int index, T value){
	    if (index > size || index < 0) throw new IndexOutOfBoundsException();
	    if (index == size){
            add(value);
            return;
	    }
	    Node newNode = new Node(value);
    	if (index == 0){
    	    first.setPrev(newNode);
    	    newNode.setNext(first);
    	    first = newNode;
    	}
    	else{
    	    Node target = first;
    	    for (int i = 0; i < index; i++){
    		target = target.getNext();
    	    }
    	    newNode.setNext(target);
    	    target.getPrev().setNext(newNode);
    	    newNode.setPrev(target.getPrev());
    	    target.setPrev(newNode);
    	}
    	size++;
    }

    public T remove(int index){
    	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    	T answer;
    	if (index == 0){
    	    first.getNext().setPrev(null);
    	    answer = first.getValue();
    	    first = first.getNext();
    	    
    	}
    	else if (index == size - 1){
    	    last.getPrev().setNext(null);
    	    answer = last.getValue();
    	    last = last.getPrev();
    	}
    	else{
    	    Node target = getNode(index);
    	    target.getPrev().setNext(target.getNext());
    	    target.getNext().setPrev(target.getPrev());
    	    answer =  target.getValue();
    	    
    	}
    	size--;
    	return answer;
    }

    public boolean remove(T val){
    	int loc = indexOf(val);
    	if (loc != -1){
    	    remove(loc);
    	    return true;
    	}
    	return false;
    }

    public String toString(){
    	String str = "[";
    	Node current = first;
    	for (int i = 0; i < size; i++){
    	    str += current.getValue() + ",";
    	    current = current.getNext();
    	}
    	if (!str.equals("[")) str = str.substring(0,str.length()-1);
    	return str + "]";
    }

    public Yeehaw iterator(){
      return new Yeehaw(first);
    }

    public int max(){
      if (size == 0) return -1;
      T biggestKevin = first.getValue();
      int kevinIndex = 0;
      int biggestKevinIndex = 0;
      for (T kevin: this){

        if(kevin.compareTo(biggestKevin) > 0){
          biggestKevin = kevin;
          biggestKevinIndex = kevinIndex;
        }
        kevinIndex++;
      }
      return biggestKevinIndex;
    }
    public int min(){
      if (size == 0) return -1;
      T biggestKevin = first.getValue();
      int kevinIndex = 0;
      int biggestKevinIndex = 0;
      for (T kevin: this){
        if(kevin.compareTo(biggestKevin) < 0){
          biggestKevin = kevin;
          biggestKevinIndex = kevinIndex;
        }
        kevinIndex++;
      }
      return biggestKevinIndex;
    }

    public void extend(MyLinkedListImproved<T> other){
	last.setNext(other.first);
	other.first.setPrev(last);
	last = other.last;
	size+=other.size;
	other.clear();
    }
    
    public static void main(String[] args){
        //crystalDriver();

	MyLinkedListImproved<Integer> kevin = new MyLinkedListImproved<>();

	MyLinkedListImproved<Integer> wesley = new MyLinkedListImproved<>();

	for (int i = 0; i < 10; i++){
	    kevin.add(i*10);
	    wesley.add(i*10 + 100);
	}

	kevin.extend(wesley);
	print("testset");
	print(kevin);
		
      /*
      MyLinkedListImproved<Integer> kevin = new MyLinkedListImproved<>();
      for (int i = 0; i < 10; i++){
        kevin.add(i*10);
      }
      print(kevin.min());
      print(kevin.max());
      */
     
    }    
    /*
    public static void kDriver(){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<T> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,T.valueOf(i));
      }
      if(nums.remove(T.valueOf(0)) && nums.remove(T.valueOf(1)) &&
      nums.remove(T.valueOf(5)) && nums.remove(T.valueOf(3)) &&
      nums.remove(T.valueOf(8))&& nums.remove(T.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (T, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }
    */
    public static void crystalDriver(){
      MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for(Integer x: a){
       System.out.print(x + " ");
     }

     System.out.println("\n" + a.max()); print(a.indexOf(90));
     System.out.println(a.min()); print(a.indexOf(0));

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
    }
    /*
    public static void myDriver(){
      	MyLinkedList kevin = new MyLinkedList();
      	 for (int i = 0; i < 10; i++){
      	     kevin.add(i * 2);
      	     print(kevin.indexOf(i*2));
      	 }
         print("wwwwww");
         print(kevin.indexOf(8));
     	  kevin.remove(T.valueOf("0"));
     	  kevin.remove(T.valueOf("18"));
     	  kevin.remove(T.valueOf("10"));
	 
     	  print(kevin);
     	   print(kevin.indexOf(0));
     	   print(kevin.indexOf(8));
     	   print(kevin.indexOf(-2));
	
     	   print("dsfoasdhjkfjas");
	
     	   kevin.add(32112);
     	   kevin.add(0, 111111);
     	   print(kevin);
     	   print("-----1----");
     	   kevin.add(kevin.size / 2, 2222);
     	   print(kevin);
     	   print("-----2----");
     	   kevin.add(kevin.size - 1, 33333);
     	   print(kevin);
     	   print("-----3----");
     	   //kevin.add(kevin.size, 44444);
     	  //kevin.add(-1, 44444);
    }
    */
    
     class Node{
  		private Node next,prev;
  		private T value;

  		public Node(){
  		    //Node(0);
  		}
  		public Node(T value){
  		    this.value = value;
  		}

  		public Node getNext(){
  		    return next;
  		}

  		public Node getPrev(){
  		    return prev;
  		}

  		public T getValue(){
  		    return value;
  		}

  		public void setNext(Node a){
  		    next = a;
  		}

  		public void setPrev(Node a){
  		    prev = a;
  		}

  		public void setValue(T a){
  		    value = a;
  		}
  		
  		public String toString(){
  		    return "[" + value + "]";
  		}
    }

    class Yeehaw implements Iterator<T>{
      Node target;

      public Yeehaw(Node first){
        target = first;
      }

      public boolean hasNext(){
        return target != null;
      }

      public T next(){
        if (hasNext()){
          T ans= target.getValue();
          target = target.getNext();
          return ans;
        }
        throw new NoSuchElementException();
      }
    }

}

