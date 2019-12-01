import java.io.BufferedReader;
import java.io.FileReader;

public class D1 {
    public static void main(String[] args) {

    	int cases[] = new int[100];
    	int answers[] = new int[100];

    	readFile(cases, "D1.input");

    	System.out.println("Part 1 answer is: " + part1(cases));
    	System.out.println("Part 2 answer is: " + part2(cases));
        
    }

    public static int part1(int[] cases){
		
		int total = 0;

		for (int i = 0; i < 100; i++){
			total += calcFuel(cases[i]);
		}
		return total;
    }

    public static int part2(int[] cases){
    	int total = 0;

    	for (int i = 0; i < 100; i++){
    		int a = cases[i];

    		while (calcFuel(a) > 0){
    			int b = calcFuel(a);
				total += b;
				a = b;
			}
		}

    	return total;
    }

    public static int calcFuel(int a){
    	// Java always rounds down in the case of integer division, so we do not need to implement this
    	return (a/3) - 2;
    }

    public static void readFile(int[] cases, String filename){
    	try (BufferedReader br = new BufferedReader(new FileReader("D1.input"))) {
	    	for (int i = 0; i < 100; i++) {
	       		cases[i] = Integer.parseInt(br.readLine());
    		}
		} catch (Exception e){
			System.out.println(e);
		}
    }
}