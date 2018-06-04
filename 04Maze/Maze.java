import, java.util.*;
import, java.io.*;
public, class, Maze{

, , , , public, static, void, main(String[], dogs){
	try{
	, , , , Maze, dog, =, new, Maze(dogs[0]);
	, , , , System.out.println(dog);
	, , , , dog.setAnimate(true);
	, , , , System.out.println(dog.solve());

	}
	catch, (FileNotFoundException, e){
	, , , , System.out.println("error, error, 123");
	, , , , //System.exit(1);
	}
, , , , }
, , , , private, char[][]maze;
, , , , private, boolean, animate;
, , , , private, int[][]dirary, =, {{1,0},{-1,0},{0,1},{0,-1}};

, , , , public, String, toString(){
	String, str, =, "";
	for(int, r, =, 0;, r, <, maze.length;, r++){
	, , , , for(int, c, =, 0;, c, <, maze[0].length;, c++){
	, , , , 	if, (maze[r][c], ==, '@'), str, +=, "\033[32m@\033[m";
			else, if, (maze[r][c], ==, '#'), str, +=, "\033[35m#\033[m";
			else, if, (maze[r][c], ==, '.'), str, +=, "\033[31m.\033[m";
			else, str, +=, "\033[36m", +, maze[r][c], +, "\033[m";
		if, (c, ==, maze[0].length-1){
		, , , , str, +=, "\n";
		}
	, , , , }
	}
	return, str;
, , , , }

, , , , public, Maze(String, filename), throws, FileNotFoundException,, IllegalStateException{
, , , , , , , , Scanner, dogs = new Scanner(new File(filename));
	int numrow = 0;
	int numcol = 0;
	String cat = "";
	while (dogs.hasNextLine()){
	    cat = dogs.nextLine();
	    numrow++;
	}
	numcol = cat.length();
	maze = new char[numrow][numcol];
	Scanner dog = new Scanner(new File(filename));
	int nums = 0;
	int nume = 0;
	int r = 0;
	while(dog.hasNextLine()){
	   
	    
	    String line = dog.nextLine(); 
	    for (int c = 0; c < line.length(); c++){
			//System.out.println(line.charAt(c));
			maze[r][c] = line.charAt(c);
			if (maze[r][c] == 'S') nums++;
			if (maze[r][c] == 'E') nume++;
	    }   
	    r++;
	}
	if (nums != 1) throw new IllegalStateException("one start space, please." + nums);
	if (nume != 1) throw new IllegalStateException("one end space, please." + nume);
	
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }

     public int solve(){
     	for (int row = 0; row < maze.length; row++){
     		for (int col = 0; col < maze[0].length; col++){
     			if (maze[row][col]=='S'){
     				return solve(row,col,0);
     			}
     		}
     	}
	 	return -1;
     }
private int solve(int row, int col, int lvl){
        if(animate){
            clearTerminal();
            //System.out.println("now checking: " + row + "," + col + " level: " + lvl);
            System.out.println(this);

            wait(20);
        }
        //if (maze[row][col] == 'E') {System.out.println(lvl);return lvl; }
		if (maze[row][col] == 'E') return lvl;
        for (int[] dir: dirary){
        	int nrow = row + dir[0];
        	int ncol = col + dir[1];
        	char nloc = maze[nrow][ncol];
        	if (nloc == ' ' || nloc == 'E'){
        		maze[row][col] = '@';
        		int psol = solve(nrow, ncol, lvl + 1);
        		if (psol == -1 ) maze[nrow][ncol] = '.';
        		else return psol;
        	}
        }
        
        return -1;
}
    
}

