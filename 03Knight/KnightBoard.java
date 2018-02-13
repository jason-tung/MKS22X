// @throws IllegalArgumentException when either parameter is negative.
// public KnightBoard(int startingRows,int startingCols)
 
//     Initialize the board to the correct size and make them all 0's 


// public String toString() 
// see format for toString below
// blank boards display 0's as underscores 
// you get a blank board if you never called solve or 
// when there is no solution 

// @throws IllegalStateException when the board contains non-zero values.
// @throws IllegalArgumentException when either parameter is negative 
//  or out of bounds.
// public boolean solve(int startingRow, int startingCol)

// @throws IllegalStateException when the board contains non-zero values. 
// @throws IllegalArgumentException when either parameter is negative 
//  or out of bounds.
// public int countSolutions(int startingRow, int startingCol)

// Suggestion:
// private boolean solveH(int row ,int col, int level) 
// // level is the # of the knight

public class KnightBoard{
    public static void main(String[] dogs){
	try{
	    KnightBoard dog = new KnightBoard(Integer.parseInt(dogs[0]), Integer.parseInt(dogs[1]));
	    dog.board[0][2] = -1;
	    dog.board[1][2] = 2;
	    dog.board[2][2] = 11;
	    System.out.println(dog);
	}
	catch (Exception e){
	    System.out.println("give inputs");
	    KnightBoard dog = new KnightBoard(10, 10);
	    dog.board[0][2] = -1;
	    dog.board[1][2] = 2;
	    dog.board[2][2] = 11;
	    System.out.println(dog);
	}

    }
    
    public int[][] board;
    public int xsize,ysize;

    public KnightBoard(int r, int c){
	board = new int[r][c];
	xsize = c;
	ysize = r;
    }

    
    public String toString(){
	String str = "\n";
	for (int y = 0; y < ysize; y++){
	    for (int x = 0; x < xsize; x++){
		int ref = board[y][x];
		if (ref == -1){
		    str += "\033[0;36m KN \033[0m";
		}
		else if (ref == 0){
		    str += "\033[0;32m 00 \033[0m"; 
		}
		else{
		    String dog;
		    if (ref < 10) dog = "0" + ref;
		    else dog = ""+  ref;
		    str += "\033[0;31m "+ dog  +" \033[0m";
		}
		if (x == xsize - 1){
		    str += "\n";
		}
		//System.out.println(str + x + " , " + y + "\n");
	    }
	}
	return str;
    }

    
}
