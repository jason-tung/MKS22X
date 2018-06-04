import java.util.*;
public class Driver{

public static void main(String[] args){
        double[] a = new double[111];
        RunningMedian test = new RunningMedian();
        for(int i = 0; i < a.length; i++){
            a[i] = 100 * Math.random();
            test.add(a[i]);
        }
        
        Arrays.sort(a);
        System.out.println(a[55]);
        System.out.println(test.getMedian());
    }
}
