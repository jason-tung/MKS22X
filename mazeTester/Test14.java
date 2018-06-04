import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Test14{
  public static String normalize(String s){
    //i don't care that this is ugly and slow.
    return (s.replace(".","#").replace(" ","#").replace("?","#").replace("S","@").replace("E","@"));
  }

  public static void main(String[]args) throws IOException,FileNotFoundException{
    String filename;
    try{
      filename = args[0];
    }catch(ArrayIndexOutOfBoundsException e){
      filename= "data1.dat";
    }
    int style;
    try{
      style = new Integer(args[1]);
    }catch(ArrayIndexOutOfBoundsException e){
      style = 1;
    }

    File file = new File(filename);
    String content = new Scanner(file).useDelimiter("\\Z").next();
    MazeSolver m = new MazeSolver(filename);

    try{
      m.solve(style);
    }catch(Exception e){
      System.out.println("FAIL RANDOM EXCEPTION IN SOLVE: "+filename+" mode: "+style+" (1=breadth,2=best,3=A*)");
      e.printStackTrace();
      System.exit(0);
    }

    String outname = filename.substring(0,filename.length()-4)+".sol"+style;
    //Files.write(Paths.get(outname), normalize(m.toString()).getBytes());

    String solution = new Scanner(new File(outname)
    ).useDelimiter("\\Z").next();
    String found = m.toString();

    while(solution.charAt(solution.length()-1)=='\n'){
      solution = solution.substring(0,solution.length()-1);
    }
    while(found.charAt(found.length()-1)=='\n'){
      found = found.substring(0,found.length()-1);
    }
    found = normalize(found);

    if(solution.equals(found)){
      System.out.println("PASS case: "+filename+" mode: "+style+" (0=breadth,2=best,3=A*)");
    }else{
      System.out.println("FAIL case: "+filename+" mode: "+style+" (0=breadth,2=best,3=A*)");

      System.out.println("solution:" + "\n" + solution + "\n");

      System.out.println("found:" + "\n" + found);
      //System.out.println("correct:\n"+solution+"\nVs:\n"+found);
    }
  }
}
