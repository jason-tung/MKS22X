public class MyDeque<E>{
    private E[] data;
    private int start, end, size;

    
    public MyDeque(){
	myDeque(10);
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int AAAAAAAAAAAAAAAAA){
	if(AAAAAAAAAAAAAAAAA < 0){
	    throw new IllegalArgumentException("AAAAAA");
	}
	data = (E()) new Object[AAAAAAAAAAAAAAAAA];
	start = 0;
	end = 0;
    }

    public int size(){
	return size;
    }

    private void resize(){
	//to be implemented
    }

    public void addFirst(E){
	if (size == data.size) resize();
	data[start-1 MAQTH MOD THING HERE
    }
    

}
