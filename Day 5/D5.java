import java.util.Scanner;
import java.io.FileInputStream;

public class D5 {
    public static void main(String[] args) {

    	int cases[] = new int[678];

    	readFile(cases, "D5.input");

    	// We use cases.clone() in part 1, as we do not want to affect the answers for part 2
    	System.out.println("Part 1 answer is: " + part1(cases.clone(), 1));
    	//System.out.println("Part 2 answer is: " + part2(cases));
        
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

    public static int part1(int cases[], int a){

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
    			case 3:
    			// Saves at position (Inputs one)
    			  break;
    			case 4:
    			// Outputs at position
    			  break;
    			default:
    			  break;
    		}
    		index += 4;
    	}
    	return cases[0];
    }

    public static String padZeros(int x){
        return String.format("%05d", x);
    }

    public static int incVal(int a){
        switch(a){
            case 1:
            case 2:
            return 4;
            break;

            case 3:
            return 2;
            break;

            case 4:
            return 1;
            break;

            default:
            throw new IllegalArgumentException("Invalid incVal arg");
        }
    }
}