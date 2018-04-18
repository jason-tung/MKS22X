import java.util.*;
public class StackCalc{
	private static boolean print = false;
	public static void print(Object a){
		if (print) System.out.println(a);
    }
	public static double eval(String str){
		String[] parsed = str.split(" ");
		LinkedList<Double> dog = new LinkedList<Double>();
		for (String waaah : parsed){
			switch (waaah) {
	            case "+":  dog.push(dog.pop() + dog.pop()); break;
	            case "-":  Double hol = dog.pop(); dog.push(dog.pop() - hol); break;
	            case "*":  dog.push(dog.pop() * dog.pop()); break;
	            case "/":  Double aba = dog.pop(); dog.push(dog.pop() / aba); break;
	            case "%":  Double das = dog.pop(); dog.push(dog.pop() % das); break;
	            default: dog.push(Double.valueOf(waaah));
        	}
        	print(waaah);
        	print(dog);
		}
		return dog.pop();
	}

	public static void main(String[] args){
		System.out.println(eval("10 2.0 +"));// is 12.0
		System.out.println(eval("11 3 - 4 + 2.5 *"));// is 30.0
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //is 893.0
	}
}

