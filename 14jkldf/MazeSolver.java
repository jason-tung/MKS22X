

import java.util.*;
import java.io.*;


class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    private int distSoFar;

    public Location(int _x, int _y, Location prev, int dist, int distSoFar){
	x = _x;
	y = _y;
	previous = prev;
  distance = dist;
  this.distSoFar = distSoFar;
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

    public int getDistSoFar(){
	return distSoFar;
    }

    public int getDistance(){
      return distance;
    }
    
    public String toString(){
	return "x: " + x + " y: " + y + " prev: " + Boolean.toString(previous != null) + " distance: " + distance;
    }
    public boolean equals(Location other){
      return other.x == x && other.y == y;
    }

    public int compareTo(Location other){
	return distance + distSoFar -  (other.distance + other.distSoFar);
    }
}

class FrontierQueue implements Frontier{
    public ArrayDeque<Location> locations;

    public FrontierQueue(){
  locations = new ArrayDeque<Location>();
    }

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
    public ArrayDeque<Location> locations;

      public FrontierStack(){
  locations = new ArrayDeque<Location>();
    }

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

class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> locations;

    public FrontierPriorityQueue(){
      locations = new MyHeap<Location>(false);
    }
    public Location next(){
  return locations.remove();
    }

    public void add(Location n){
  locations.add(n);
    }

    public boolean hasNext(){
  return locations.peek() != null;
    }
}   
//"--------------------------------------------------------------------------";

class Maze{
  private Location start,end;
  public char[][] maze;
    private boolean isAStar;

    public void setAStar(boolean a){
	isAStar = a;
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
			if (maze[r][c] == 'S'){
			    nums++;
			    start = new Location(c,r,null, 0, 0);
			}
			if (maze[r][c] == 'E'){
			    nume++;
			    end = new Location(c,r,null, 0, 0);
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
    public static int getDistance(int x, int y,Location other){
      return Math.abs(x-other.getX())+Math.abs(y-other.getY());
    }
    public String toString(){
	String str = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
	    	if (maze[r][c] == '@') str += "\033[32m@\033[m";
		else if (maze[r][c] == '#') str += "\033[35m#\033[m";
		else if (maze[r][c] == '?') str += "\033[34m?\033[m";
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
        int tempx = currentX + mod[0];
        int tempy = currentY + mod[1];
        if (tempx >= 0 && tempy >= 0 && tempx < maze[0].length && tempy < maze.length && (maze[tempy][tempx] == ' ' || maze[tempy][tempx] == 'E' || maze[tempy][tempx] == 'S'))
	    if (!isAStar) temp.add(new Location(tempx,tempy,n, getDistance(tempx, tempy, end), 0));
	    else temp.add(new Location(tempx,tempy,n, getDistance(tempx, tempy, end),  n.getDistSoFar() + 1));
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
  private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
      public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }


  public  boolean animate;
    public void setAnimate(boolean a){
	animate = a;
    }
  public boolean solve(int mode){
   if (mode == 0){
      frontier = new FrontierQueue();
    }
    else if( mode == 1){
      frontier = new FrontierStack();
    }
    else {
	maze.setAStar(true);
	if(mode == 2)maze.setAStar(false);
	frontier = new FrontierPriorityQueue();
    }
    //System.out.println(maze.getStart());
    frontier.add(maze.getStart());
    while(frontier.hasNext()){
      //****************************************************************************************************
      if(animate){
            clearTerminal();
            //System.out.println("now checking: " + row + "," + col + " level: " + lvl);
            System.out.println(this);

            wait(20);
        }
        //*****************************************************************************************************
      Location temp = frontier.next();
      if (temp.equals(maze.getEnd())) return true;
      if (maze.maze[temp.getY()][temp.getX()] != 's') maze.maze[temp.getY()][temp.getX()] = '.';
      for (Location neighbor: maze.getNeighbors(temp)){
        if (neighbor.equals(maze.getEnd())) return true;
        frontier.add(neighbor);
        maze.maze[neighbor.getY()][neighbor.getX()] = '?';
      }
    }
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    return false;
  }

  /*private void replace(Location loc, char c){
    maze[loc.getY()][loc.getX()] = c;
  }*/

  public String toString(){
    return maze.toString();
  }

    public static void main(String[] args){
	try{
	    MazeSolver kevin = new MazeSolver("data4.dat");
	    System.out.println(kevin);
	    kevin.setAnimate(true);
	    System.out.println(kevin.solve(3));
	    System.out.println(kevin);
	    kevin.setAnimate(false);
	}
	catch (FileNotFoundException e){
	    e.printStackTrace();
	}
    }
    
}
