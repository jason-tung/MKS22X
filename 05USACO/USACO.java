import java.io.*;
import java.util.*;

public class USACO{

    //makelake
    public static int bronze(String input){
    	try{
			Scanner in = new Scanner(new File(input));
			int okay = 0;
			int r = 0;
			int c = 0;
			int e = 0;
			int n = 0;
			while(in.hasNext()){
			    int ref = Integer.parseInt(in.next());
			    if (okay == 0) r = ref;
			    if (okay == 1) c = ref;
			    if (okay == 2) e = ref;
			    if (okay == 3) n = ref;
			    okay++;
			}
			Scanner in2 = new Scanner(new File(input));
			int[][] map = new int[r][c];
			int[][] commands = new int[n][3];
			int lineno = 0;
			while(in2.hasNextLine()){
			    String ref = in2.nextLine();
			    if (lineno > 0 && lineno < r + 1){
			    	//System.out.println(ref);
					int[] dogs = parse(ref,c);

					for (int col = 0; col < c; col++){
				    	map[lineno - 1][col] = dogs[col];
					}

			    }
			    else if(lineno >= r + 1){
			    	int[] dogs = parse(ref,3);
			    	for (int i = 0; i < 3; i++){
			    		//System.out.println("else if error:" + (lineno - (r+1)) + " " +  lineno);
			    		commands[lineno-(r+1)][i] = dogs[i];
			    	}
				}
				lineno++;
		    }
		    //System.out.println(toString(map));
		    //System.out.println(toString(commands));
		    for (int[] cmds: commands){
		    	int row = cmds[0] - 1;
		    	int col = cmds[1] - 1;
		    	int dep = cmds[2];
		    	int maxdep = 0;
		    	for (int trow = row; trow < row + 3; trow++){
		    		for (int tcol = col; tcol < col + 3; tcol++){
		    			try{
		    				if (map[trow][tcol] > maxdep) maxdep = map[trow][tcol];
		    			}
		    			catch(Exception b){}
		    		}
		    	}
		    	
		    	//System.out.println(maxdep);
		    	int newmaxdep = maxdep - dep;
		    	if (newmaxdep < 0) newmaxdep = 0;
		    	//System.out.println(newmaxdep);
		    	for (int trow = row; trow < row + 3; trow++){
		    		for (int tcol = col; tcol < col + 3; tcol++){
		    			try{
		    				if (map[trow][tcol] > newmaxdep) map[trow][tcol] = newmaxdep;
		    				//else System.out.println(map[trow][tcol] + " " + newmaxdep);
		    			}
		    			catch(Exception b){}
		    		}
		    	}
		    	
		    }
		    //System.out.println(e);
		    int tot = 0;
		    for (int x = 0; x < map.length; x++){
				for (int y = 0; y< map[0].length;y++){
					int depth = e - map[x][y];
					if (depth > 0){
						tot+=depth;
					}
				}
			}
		    //System.out.println(toString(map));
		    //System.out.println(toString(map));
		    return 72 * 72 * tot;
		}
		catch(FileNotFoundException b){
		System.out.println("no such file");

        return -1;
      }

	}

	public static String toString(int[][] ary){
		String str = "";
		for (int x = 0; x < ary.length; x++){
			for (int y = 0; y< ary[0].length;y++){
				if (ary[x][y] < 10) str+= "0";
				str += ary[x][y] + " ";
				if (y == ary[0].length - 1) str+="\n";
			}
		}
		return str;
	}

    public static int[] parse(String str, int cols){
		int charnum = 0;
		int numspassed = 0;
		String currentword = "";
		int[] listy = new int[cols];
		while(numspassed < cols){
			//System.out.println(str.length() + " " + charnum + " " + numspassed + " " + currentword);
		    if (charnum == str.length() || str.charAt(charnum) == ' '){
				try{
					listy[numspassed] = Integer.parseInt(currentword);
				} 
				catch (Exception e) {
					System.out.println(cols + " " + charnum);
				}
				currentword = "";
				numspassed++;
		    }
		    else{
		    	
				currentword+=str.charAt(charnum);
		    }
		    charnum++;
		}
		return listy;
    }

    public static void main(String[] args){
    	//System.out.println("" + parse("22 45 52",3)[0] + parse("22 45 52",3)[1] + parse("22 45 52",3)[2]);
    	System.out.println(bronze("makelake.1.in"));
    }
}
