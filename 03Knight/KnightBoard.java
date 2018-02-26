//5x5 count sol (0,0) 304
//5x5 add all count sols 1728

public class KnightBoard{
    public static void main(String[] dogs){

	KnightBoard dog = new KnightBoard(Integer.parseInt(dogs[0]), Integer.parseInt(dogs[1]));
	System.out.println(dog.solve(2,1));
	System.out.println(dog);

    }
    
    public int[][] board;
    public int colsize,rowsize;

    public KnightBoard(int r, int c){
	if (r < 0 || c < 0) throw new IllegalArgumentException();
	board = new int[r][c];
	colsize = c;
	rowsize = r;
    }

    
    public String toString(){
	String str = "\n";
	for (int y = 0; y < rowsize; y++){
	    for (int x = 0; x < colsize; x++){
		int ref = board[y][x];
		String dog;
		if (ref < 10) dog = "0" + ref;
		else dog = ""+  ref;
		str += "\033[0;32m "+ dog  +" \033[0m";

		if (x == colsize - 1){
		    str += "\n";
		}
		//System.out.println(str + x + " , " + y + "\n");
	    }
	}
	return str;
    }


    public boolean addKnight(int r, int c, int level){
	if (r >= 0 && r < rowsize && c >= 0 && c < colsize && board[r][c] == 0){
	    board[r][c] = level;
	    //System.out.println(this);
	    return true;
	}
	// System.out.println("row: " + r + " col: " + c + " level:" + level);
	// System.out.println("rowsize: " + rowsize + " colsize: " + colsize);
	return false;
    }

    public boolean removeKnight(int r, int c){
	if (r >= 0 && r < rowsize && c >= 0 && c < colsize){
	    board[r][c] = 0;
	    return true;
	}
	return false;
    }

    public boolean solve(int r, int c){
	if (r < 0 || c < 0) throw new IllegalArgumentException();
	for (int[] x: board){
	    for (int y: x){
		if (y != 0) throw new IllegalStateException();
	    }
	}
	return solveH(r, c, 1);
    }

    public boolean solveH(int r, int c, int level){
        if (level == colsize * rowsize ){
	    return addKnight(r,c,level);
	}
        if (addKnight(r,c,level)){
	    //System.out.println(this);
	    int[][] cat = {{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
	    for (int kitten = 0; kitten < 8; kitten++){
		if (solveH(r + cat[kitten][0], c + cat[kitten][1], level + 1)){
		    return true;
		    // System.out.println(removeKnight(r,c));
		}		
	    }
	    removeKnight(r,c);
	}
        
	return false;
    }

    
    
}
