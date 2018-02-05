public class Recursion{
    public static void main(String[] args){
	Recursion jerry = new Recursion();
	//System.out.println(jerry.fact(-1));
	System.out.println(jerry.fact(0));
	System.out.println(jerry.fact(1));
	System.out.println(jerry.fact(2));
	System.out.println(jerry.fact(3));
	System.out.println(jerry.fact(4));
	System.out.println(jerry.fact(5));
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException("n must be > 0");
	}
        return factHelper(n,1);
    }

    public int factHelper(int n, int tot){
	if (n == 0){
	    return tot;
	}
	return factHelper(n-1, tot * n);
    }
    
}
