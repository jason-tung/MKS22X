public class MyLinkedList{

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

    public Integer get(int index){
	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
	return getNode(index).getValue();
    }

    public Integer set(int index, Integer value){
	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
	Node kevin = getNode(index);
	kevin.setValue(value);
	return kevin.getValue();
    }

    public int indexOf(Integer val){
	Node current = first;
	for (int i = 0; i <= size; i++){
	    if (current.getValue() == val) return i;
	    if (i < size - 1) current = current.getNext();
	}
	return -1;
	
    }

    public boolean add(Integer value){
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

    public void add(int index, Integer value){
	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
	if (index == size - 1){
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

    public Integer remove(int index){
	if (index >= size || index < 0) throw new IndexOutOfBoundsException();
	Integer answer;
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

    public boolean remove(Integer val){
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
    
       public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

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

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }
    

     // public static void main(String[] args){
     // 	MyLinkedList kevin = new MyLinkedList();
     // 	 for (int i = 0; i < 10; i++){
     // 	     kevin.add(i * 2);
     // 	     print(kevin.indexOf(i*2));
     // 	 }
     	 // kevin.remove(Integer.valueOf("0"));
     	 // kevin.remove(Integer.valueOf("18"));
     	 // kevin.remove(Integer.valueOf("10"));
	 
     	 // print(kevin);
     	 //  print(kevin.indexOf(0));
     	 //  print(kevin.indexOf(8));
     	 //  print(kevin.indexOf(-2));
	
     	 //  print("dsfoasdhjkfjas");
	
     	 //  kevin.add(32112);
     	 //  kevin.add(0, 111111);
     	 //  print(kevin);
     	 //  print("-----1----");
     	 //  kevin.add(kevin.size / 2, 2222);
     	 //  print(kevin);
     	 //  print("-----2----");
     	 //  kevin.add(kevin.size - 1, 33333);
     	 //  print(kevin);
     	 //  print("-----3----");
     	 //  kevin.add(kevin.size, 44444);
     	 //  kevin.add(-1, 44444);
     }
    




    

     class Node{
		private Node next,prev;
		private Integer value;

		public Node(){
		    //Node(0);
		}
		public Node(Integer value){
		    this.value = value;
		}

		public Node getNext(){
		    return next;
		}

		public Node getPrev(){
		    return prev;
		}

		public Integer getValue(){
		    return value;
		}

		public void setNext(Node a){
		    next = a;
		}

		public void setPrev(Node a){
		    prev = a;
		}

		public void setValue(int a){
		    value = a;
		}
		
		public String toString(){
		    return "[" + value + "]";
		}
    }
	

}

