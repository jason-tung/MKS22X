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
