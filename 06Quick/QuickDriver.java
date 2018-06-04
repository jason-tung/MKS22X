import java.util.*;

public class QuickDriver{

    public static void main(String[]args){
	int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
	System.out.println(Quick.quickselect(ary,5) + " <- Should be 0");
	int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
	System.out.println(Quick.quickselect(ary1,19) + " <- Should be 7");
	System.out.println(Quick.quickselect(ary1,13) + " <- Should be 5");
	System.out.println(Quick.quickselect(ary1,0) + " <- Should be -3");
	System.out.println(Quick.quickselect(ary1,ary1.length-1) + " <- Should be 9");
	int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
	Quick.quicksort(ary2);
	System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
	System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");



	int[] ary3 = {3,3,3,3,3,3,3,3};
	Quick.quicksort(ary3);
	System.out.println("Your sorted array" + "\n" + Arrays.toString(ary3));
    }
}