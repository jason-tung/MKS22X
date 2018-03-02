import java.util.*;
import java.io.*;
public class Maze{

    public static void main(String[] dogs){
	try{
	    Maze dog = new Maze(dogs[0]);
	    System.out.println(dog);
	}
	catch (FileNotFoundException e){
	    System.out.println("wat da fak");
	    //System.exit(1);
	}
    }
    private char[][]maze;
    private boolean animate;

    public String toString(){
	String str = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		str += maze[r][c];
		if (c == maze[0].length-1){
		    str += "\n";
		}
	    }
	}
	return str;
    }

    public Maze(String filename) throws FileNotFoundException, IllegalStateException{
        Scanner dogs = new Scanner(new File(filename));
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
		if (nums > 1 || nume > 1) throw new IllegalStateException();
		
	    }   
	    r++;
	}
	
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
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

     public int solve(){
            //find the location of the S. 

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
	 return 0;
     }
private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return -1; //so it compiles
}
    
}

