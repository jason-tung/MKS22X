

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
	String str = "";
	for (int y = 0; y < size; y++){
	    for (int x = 0; x < size; x++){
		int ref = board[y][x];
		if (ref == 1){
		    str += " Q ";
		}
		else{
		    str += " _ ";
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
	return false;
    }
    private boolean removeQueen(int r, int c){
	return false;
    }

    public static void main(String[] args){
	QueenBoard dog = new QueenBoard(Integer.parseInt(args[0]));
	System.out.println(dog);
    }
	

    
}
