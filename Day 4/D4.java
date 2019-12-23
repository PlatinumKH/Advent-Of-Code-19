import java.util.Scanner;
import java.io.FileInputStream;

public class D4 {
    public static void main(String[] args) {

    	// My input is "130254-678275";
    	int minInput = 130254;
    	int maxInput = 678275;

    	System.out.println("Part 1 answer is: " + part1(minInput, maxInput));
    	System.out.println("Part 2 answer is: " + part2(minInput, maxInput));
        
    }

    public static int part1(int minInput, int maxInput){
    	int count = 0;
    	for (int i = minInput; i <  maxInput + 1; i++){
    		count += (conditionA(i) && conditionB(i))?1:0;
    	}
    	return count;
    }

    public static boolean conditionA(int x){
    	// At least two digits in the number are adjacent
    	for (int i = 0; i < 5; i++){
    		if (getnthDigit(x, 5-i) == getnthDigit(x, 4-i)) return true;
    	}
    	return false;
    }

    public static boolean conditionB(int x){
    	// The digits from left to right are non-decreasing
    	for (int i = 0; i < 5; i++){
    		if (getnthDigit(x, 5-i) > getnthDigit(x, 4-i)) return false;
    	}
    	return true;
    }

    public static int getnthDigit(int x, int n){
    	if (n == 0) return x%10;
    	else if (n == 5) return x/100000;
    	else
    	{
    		int div = (int) Math.pow(10, n);
    		int div2 = (int) Math.pow(10, 1);
    		return (x/div)%div2;
    	}
    }

    public static int part2(int minInput, int maxInput){
    	int count = 0;
    	for (int i = minInput; i <  maxInput + 1; i++){
    		count += (conditionC(i) && conditionB(i))?1:0;
    	}
    	return count;
    }

    public static boolean conditionC(int x){

    	// At least two digits in the number are adjacent
    	for (int i = 0; i < 5; i++){
    		if (getnthDigit(x, 5-i) == getnthDigit(x, 4-i)) {
    			if (i != 4){
    				if (getnthDigit(x, 5-i) == getnthDigit(x, 3-i)) {
    					int a = getnthDigit(x, 5-i);
    					// Move counter to next different number
    					while ((getnthDigit(x, 5-i) == a) && (i != 5)) i++;
    					
    					// Accounting for when the loop increments i (or returning false if we have reached the end)
    					if (i == 5) return false;
    					i -= 1;
    				} else {
    					return true;
    				}
    			} else return true;
    		}
    	}
    	return false;
    }
}