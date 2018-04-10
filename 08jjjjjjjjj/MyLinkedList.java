public class MyLinkedList{

    private Node first,last;
    private int size;

    public static boolean print = true;

    public static void print(Object a){
		if (print) System.out.println(a);
    }

    public MyLinkedList(){
    	first = null;
    	last = null;
    	size = 0;
    }

    private Node getNode(int index){
	if (index >= size && index >= 0) throw new IndexOutOfBoundsException();
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
	return getNode(index).getValue();
    }

    public Integer set(int index, Integer value){
	Node kevin = getNode(index);
	kevin.setValue(value);
	return kevin.getValue();
    }

    public boolean add(Integer value){
    	//if (value < 0) throw new IndexOutOfBoundsException();
    	if (size == 0){
    		first = new Node(value);
		last = first;
    	}
    	Node newNode = new Node(value);
    	newNode.setPrev(last);
	last.setNext(newNode);
    	last = newNode;
	size++;
	System.out.println(newNode.getPrev() + " "+ newNode + " "  + newNode.getNext() + " " + value);
    	return true;
    }

    public String toString(){
    	String str = "[";
	Node current = first;
	for (int i = 0; i < size; i++){
	    str += current.getValue() + ",";
	    current = first.getNext();
	}
	if (!str.equals("[")) str = str.substring(0,str.length()-1);
	return str + "]";
    }

    public static void main(String[] args){
	MyLinkedList kevin = new MyLinkedList();
	for (int i = 0; i < 10; i++){
	    kevin.add((int) (i * Math.random()));
	}
	print(kevin);
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

