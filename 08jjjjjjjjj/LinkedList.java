public class LinkedList{

	private Node first,last;
	private int size;

    public static boolean print = true;

    public static void print(Object a){
		if (print) System.out.println(a);
    }

    public LinkedList(){
    	first = null;
    	last = null;
    	length = 0;
    }

    public boolean add(int value){
    	if (value < 0 || value >= size) throw new IndexOutOfBoundsException();
    	if (size == 1){
    		first = new Node(value);
    	}
    	Node newNode = new Node(value);
    	newNode.setPrev(last);
    	last.setNext(newNode);
    	return true;
    }

    public int size(){
    	return size;
    }

    public String toString(){
    	return null;
    }

    public static void main(String[] args){
	
    }
    






    private class Node{
		private Node next,prev;
		private int data;

		public Node(){
		    //Node(0);
		}
		public Node(int data){
		    this.data = data;
		}

		private Node getNext(){
		    return next;
		}

		private Node getPrev(){
		    return prev;
		}

		public int getData(){
		    return data;
		}

		private void setNext(Node a){
		    next = a;
		}

		private void setPrev(Node a){
		    prev = a;
		}

		private void setData(int a){
		    data = a;
		}
		
		public String toString(){
		    return "[" + data + "]";
		}
    }
	

}

