import java.util.*;
import java.io.*;
public class Maze{

    public static void main(String[] dogs){
	try{
	    Scanner dog = new Scanner(new File(dogs[0]));
	    System.out.println(dog);
	}
	catch (FileNotFoundException e){
	    
	}
    }
    private char[][]maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException, IllegalStateException{
         
	Scanner dog = new Scanner(new File(filename));
	while(dog.hasNextLine()){
	    incr = 0;
	    
	    String line = dog.nextLine();
	    for (int x = 0; x < line.length(); x++){
		maze[incr][x] = line.charAt(x);
	    }
	    incr++;
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

