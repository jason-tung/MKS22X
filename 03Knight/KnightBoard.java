public class KnightBoard{
    public static void main(String[] dogs){

	    KnightBoard dog = new KnightBoard(Integer.parseInt(dogs[0]), Integer.parseInt(dogs[1]));
	    System.out.println(dog.solve(0,0));
	    System.out.println(dog);

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
		    str += "\033[0;31m "+ "00"  +" \033[0m";
		}
		if (x == xsize - 1){
		    str += "\n";
		}
		//System.out.println(str + x + " , " + y + "\n");
	    }
	}
	return str;
    }

    public boolean addKnight(int r, int c){
	if (r >= 0 && r < ysize && c >= 0 && c < xsize && board[r][c] == 0){
	    board[r][c] = -1;
	    //System.out.println(this);
	    return true;
	}
	return false;
    }

    public boolean removeKnight(int r, int c){
	if (r >= 0 && r < ysize && c >= 0 && c < xsize && board[r][c] == 0){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }

    public boolean solve(int r, int c){
	return solveH(r, c, 0);
    }

    public boolean solveH(int r, int c, int level){
        if (level == xsize * ysize){
	    return true;
	}
        if (addKnight(r,c)){
	    return solveH(r+2, c+1, level+1) || solveH(r+2, c-1, level+1) ||
		solveH(r-2, c+1, level+1) || solveH(r-2, c-1, level+1) ||
		solveH(r+1, c+2, level+1) || solveH(r+1, c-2, level+1) ||
		solveH(r-1, c+2, level+1) || solveH(r-1, c-2, level+1);
	}
	removeKnight(r,c);
	return false;
    }

    
    
}
