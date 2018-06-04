import java.util.*;
import java.io.*;

public class USACODriver{

    public static void main(String[] args){
	for (int i = 1; i < 11; i ++){
	    String file = "makelake/makelake." + i; // Remove the "makelake/" if the test files are in the same directory
	    int ans = getAnswer(file + ".out");
	    
	    int ansU = USACO.bronze(file + ".in");
	    
	    System.out.println("Your Answer: " + ansU);
	    System.out.println("Answer: " + ans);
	    System.out.println("Correct? " + (ans == ansU));
	}


	for (int i = 1; i < 11; i ++){
	    String file = "ctravel/ctravel." + i; // Remove the "ctravel/" if the test files are in the same directory
	    int ans = getAnswer(file + ".out");
	    
	    int ansU = USACO.silver(file + ".in");
	    
	    System.out.println("Your Answer: " + ansU);
	    System.out.println("Answer: " + ans);
	    System.out.println("Correct? " + (ans == ansU));
	}
	//System.out.println(USACO.silver("ctravel/ctravel.1.in"));
    }

    public static int getAnswer(String filename){
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    
	    String inty = s.nextLine();
	    return Integer.parseInt(inty);
	    
	}catch (FileNotFoundException e){
	    System.out.println("FILE!");
	}
	return 0;
    }
 
}