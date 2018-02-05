public class Recursion{
    public static void main(String[] args){
	Recursion jerry = new Recursion();
	//System.out.println(jerry.fact(-1));
	System.out.println(jerry.fib(0));
	System.out.println(jerry.fib(1));
	System.out.println(jerry.fib(2));
	System.out.println(jerry.fib(3));
	System.out.println(jerry.fib(4));
	System.out.println(jerry.fib(5));
	System.out.println(jerry.fib(10));
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

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException("n must be > 0");
	}
	return fibHelper(n,0,1);
    }

    public int fibHelper(int n, int a, int b){
	if (n ==0){
	    return a;
	}
	return fibHelper(n-1,b,a+b);
    }
    
}
