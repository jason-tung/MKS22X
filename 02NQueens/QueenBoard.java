public class QueenBoard{
    private int[][]board;
    private int size;

    public QueenBoard(int size){
	if (size <= 0){
	    throw new IllegalArgumentException("size cannot be <= 0");
	}
	this.size = size;
	board = new int[size][size];
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
		    str += "\033[0;31m x \033[0m";
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
	if (r >= size || c >= size) return false;
        if (board[r][c] == 0){
	    board[r][c] = -1;
	    for (int i = 1; i < size; i++){
	        theDeed(r + i, c, 1);
		theDeed(r - i, c, 1);
		theDeed(r + i, c + i, 1);
		theDeed(r - i, c + i, 1);
		theDeed(r + i, c - i, 1);
		theDeed(r - i, c - i, 1);
		theDeed(r, c + i, 1);
		theDeed(r, c - i, 1);
      	    }
	    return true;
	}
	//System.out.println("row : " + r + " col: " + c + " failed");
	return false;
    }

    private void theDeed(int r, int c, int incr){
	if (r < size && r >= 0 && c < size && c >= 0){
	    board[r][c]+= incr;
	}
    }
    
    private boolean removeQueen(int r, int c){ 
         if (board[r][c] == -1){
	     board[r][c] = 0;
	    for (int i = 1; i < size; i++){
	        theDeed(r + i, c, -1);
		theDeed(r - i, c, -1);
		theDeed(r + i, c + i, -1);
		theDeed(r - i, c + i, -1);
		theDeed(r + i, c - i, -1);
		theDeed(r - i, c - i, -1);
		theDeed(r, c + i, -1);
		theDeed(r, c - i, -1);
      	    }
	    return true;
	}
	//System.out.println("row : " + r + " col: " + c + " failed");
	return false;
    }

    public boolean solve(){
	for (int[] x: board){
	    for (int y : x){
		if (y != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	
	return solverH(0);
    }

    public boolean solverH(int row){
	if (row == size){
	    return true;
	}
	for (int col = 0; col < size; col++){
	    if (addQueen(row,col) && solverH(row + 1)){
		return true;
	    }
	    removeQueen(row,col);
	   
	}
	return false;
    }

    public boolean countSolutions(){
	for (int[] x: board){
	    for (int y : x){
		if (y != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	
	return countH(0,0);
    }

    public boolean countH(int row, int tot){
	if (row == size){
	    return true;
	}
	for (int col = 0; col < size; col++){
	    if (addQueen(row,col) && countH(row + 1, tot)){
		return countH(row + 1, tot++);
	    }
	    removeQueen(row,col);
	   
	}
	return false;
    }
    
    public static void main(String[] args){
	QueenBoard dog = new QueenBoard(Integer.parseInt(args[0]));
	System.out.println(dog.solve());
	System.out.println(dog);
	//System.out.println(dog.solve());

    }
	

    
}
