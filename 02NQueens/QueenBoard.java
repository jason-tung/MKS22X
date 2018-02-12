public class QueenBoard{
    private int[][]board;
    private int size;

    public QueenBoard(int size){
	if (size <= 0){
	    throw new IllegalArgumentException("size cannot be <= 0");
	}
	this.size = size;
	board = new int[size][size];
	for (int x = 0; x < size; x++){
	    for (int y = 0; y < size; y++){
		board[y][x] = 0;
	    }
	}
    }

    public String toString(){
	String str = "\n";
	for (int y = 0; y < size; y++){
	    for (int x = 0; x < size; x++){
		int ref = board[y][x];
		if (ref == -1){
		    str += "\033[0;36m Q \033[0m";
		}
		else if (ref == 0){
		    str += "\033[0;32m 0 \033[0m"; 
		}
		else{
		    str += "\033[0;31m "+ ref  +" \033[0m";
		}
		if (x == size - 1){
		    str += "\n";
		}
		//System.out.println(str + x + " , " + y + "\n");
	    }
	}
	return str;
    }

    private boolean addQueen(int r, int c){
        if (board[r][c] == 0){
	    board[r][c] = -1;
	    for (int i = 1; i < size; i++){
	        theDeed(r + i, c);
		theDeed(r - i, c);
		theDeed(r + i, c + i);
		theDeed(r - i, c + i);
		theDeed(r + i, c - i);
		theDeed(r - i, c - i);
		theDeed(r, c + i);
		theDeed(r, c - i);
      	    }
	    return true;
	}
	//System.out.println("row : " + r + " col: " + c + " failed");
	return false;
    }

    private void theDeed(int r, int c){
	if (r < size && r >= 0 && c < size && c >= 0){
	    board[r][c]++;
	}
    }
    
    private boolean removeQueen(int r, int c){ 
	return false;
    }

    public static void main(String[] args){
	QueenBoard dog = new QueenBoard(Integer.parseInt(args[0]));
	System.out.println(dog.addQueen(2,5));
	 System.out.println(dog);
	System.out.println(dog.addQueen(5,5));
	 System.out.println(dog);
	 System.out.println(dog.addQueen(4,5));
	 System.out.println(dog);
 	System.out.println(dog.addQueen(0,1));
	System.out.println(dog);
    }
	

    
}
