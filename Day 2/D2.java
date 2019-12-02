import java.util.Scanner;
import java.io.FileInputStream;

public class D2 {
    public static void main(String[] args) {

    	int cases[] = new int[149];

    	readFile(cases, "D2.input");

    	// We use cases.clone() in part 1, as we do not want to affect the answers for part 2
    	System.out.println("Part 1 answer is: " + part1(cases.clone(), 12, 2));
    	System.out.println("Part 2 answer is: " + part2(cases));
        
    }

    public static void readFile(int cases[], String filename){
		try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
	    	scanner.useDelimiter(",");
			
			for (int i = 0; i < cases.length; i++){
				cases[i] = scanner.nextInt();
			}
		} catch (Exception e){
			System.out.println(e);
		}
    }

    public static int part1(int cases[], int a, int b){

    	// Restoring pre-program 'gravity assist'
    	cases[1] = a;
    	cases[2] = b;

    	int index = 0;

    	// Program halts at 99
    	while (cases[index] != 99){
    		switch(cases[index]){
    			case 1:
    			// Addition
    			cases[cases[index + 3]] = cases[cases[index + 1]] + cases[cases[index + 2]];
    			  break;
    			case 2:
    			// Multiplication
    			cases[cases[index + 3]] = cases[cases[index + 1]] * cases[cases[index + 2]];
    			  break;
    			default:
    			  break;
    		}
    		index += 4;
    	}
    	return cases[0];
    }

    public static int part2(int cases[]){

    	// Simple O^2 solution

    	int ans = 19690720;

    	for (int x = 0; x < 100; x++){
    		for (int y = 0; y < 100; y++){
    			try {
    				if (part1(cases.clone(), x, y) == ans) return (100 * x + y);
    			} catch (Exception e){
    				// Try the next loop
    			}
    		}
    	}

    	return -1;
    }
}