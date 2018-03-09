import java.io.*;
import java.util.*;

public class USACO{
    //makelake
    public static int makelake(String input)throws FileNotFoundException{
	Scanner in = new Scanner(new File(input));
	int okay = 0;
	int r = 0;
	int c = 0;
	int e;
	int n;
	while(in.hasNext()){
	    int ref = Integer.parseInt(in.next());
	    if (okay == 0) r = ref;
	    if (okay == 1) c = ref;
	    if (okay == 2) e = ref;
	    if (okay == 3) n = ref;
	    okay++;
	}
	Scanner in2 = new Scanner(new File(input));
	int[][] array = new int[r][c];
	int lineno = 0;
	while(in2.hasNextLine()){
	    String ref = in2.nextLine();
	    if (lineno > 0 && lineno < r + 1){
		int[] dogs = parse(ref,c);
		for (int col = 0; col < c; c++){
		    array[lineno - 1][col] = dogs[col];
		}
	    }
	    else if(lineno >r){
		
	    lineno++;
	}
    }

    public static int[] parse(String str, int cols){
	int checky = 0;
	String wordy = "";
	int[] listy = new int[cols];
	while(checky < str.length()){
	    if (str.charAt(checky) != ' '){
		wordy+=str.charAt(checky);
	    }
	    else{
		listy[checky] = Integer.parseInt(wordy);
		wordy = "";
	    }
	    checky++;
	}
	return listy;
    }
}
