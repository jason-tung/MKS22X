import java.util.*;
import java.io.*;


class Location{
    private int x,y;
    private Location previous;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){
	return x;
    }
    
    public int getY(){
	return y;
    }

    public Location getPrevious(){
	return previous;
    }
    public String toString(){
	return "x: " + x + " y: " + y + " prev: " + Boolean.toString(previous != null);
    }
}

class FrontierQueue implements Frontier{
    public Deque<Location> locations;

    public Location next(){
	return locations.removeLast();
    }

    public void add(Location n){
	locations.addFirst(n);
    }

    public boolean hasNext(){
	return locations.peekLast() != null;
    }
}

class FrontierStack implements Frontier{
    public Deque<Location> locations;

    public Location next(){
	return locations.removeFirst();
    }

    public void add(Location n){
	locations.addFirst(n);
    }

    public boolean hasNext(){
	return locations.peekFirst() != null;
    }
}

//"--------------------------------------------------------------------------";

class Maze{
  private Location start,end;
  private char[][] maze;

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
			if (maze[r][c] == 'S'){
			    nums++;
			    start = new Location(c,r,null);
			}
			if (maze[r][c] == 'E'){
			    nume++;
			    end = new Location(c,r,null);
			}
	    }   
	    r++;
	}
	if (nums != 1) throw new IllegalStateException("one start space, please." + nums);
	if (nume != 1) throw new IllegalStateException("one end space, please." + nume);

	
	
    }
  // '#' - wall 
  // ' ' - open space
  // '?' - frontier space
  // '.' - visited space
  // 'E' - end space (do not replace this)
  // '@' - part of solution
  // 'S' - starting space (do not replace this)
    public String toString(){
	String str = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
	    	if (maze[r][c] == '@') str += "\033[32m@\033[m";
		else if (maze[r][c] == '#') str += "\033[35m#\033[m";
		else if (maze[r][c] == '?') str += "\033[35m?\033[m";
		else if (maze[r][c] == '.') str += "\033[31m.\033[m";
		else str += "\033[36m" + maze[r][c] + "\033[m";
		if (c == maze[0].length-1){
		    str += "\n";
		}
	    }
	}
	return str;
    }
   
    // Work on this method as a group! 
  public String toStringColor(){
      return toString();
  }

  //return a list of Locations that are:
  // adjacent to n and  not visited
  // all the Locations in this list should have their previous set to n.
    private static int[][] mods = {{0,1},{0,-1},{1,0},{-1,0}};
  public Location[] getNeighbors(Location n){
      int currentX  = n.getX();
      int currentY = n.getY();
      ArrayList<Location> temp = new ArrayList<>();
      for (int[] mod:mods){
	  temp.add(new Location(currentX+mod[0], currentY + mod[1], n));
      }
      Location[] neighbors = new Location[temp.size()];
      for (int i = 0; i < neighbors.length; i++){
	  neighbors[i] = temp.get(i);
      }
      return neighbors;
  }

  public Location getStart(){
    return start;
  }

  public Location getEnd(){
    return end;
  }



}

public class MazeSolver{
  public Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText)throws FileNotFoundException, IllegalStateException{
      maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    return false;
  }

  public String toString(){
    return maze.toString();
  }

    public static void main(String[] args){
	try{
	    MazeSolver kevin = new MazeSolver("data1.dat");
	    System.out.println(kevin);
	    System.out.println(kevin.maze.getStart());
	    System.out.println(kevin.maze.getEnd());
	}
	catch (FileNotFoundException e){
	}
    }
}
