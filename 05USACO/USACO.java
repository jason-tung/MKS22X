import java.io.*;
import java.util.*;

public class USACO{
    //makelake
    public static int makelake(String input){
	Reader in = new Reader(new File(input));
	int okay = 0;
	int r;
	int c;
	int e;
	int n;
	while(in.hasNext()){
	    String ref = in.next();
	    if (okay == 0) r = ref;
	    if (okay == 1) c = ref;
	    if (okay == 2) e = ref;
	    if (okay == 3) n = ref;
	    okay++;
	}
	Reader in2 = new Reader(new File(input));
	int[][] array = new int[r][c];
	
    }
}
