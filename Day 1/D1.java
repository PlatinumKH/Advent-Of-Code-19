import java.io.BufferedReader;
import java.io.FileReader;

public class D1 {
    public static void main(String[] args) {
        int cases[] = new int[100];

        try (BufferedReader br = new BufferedReader(new FileReader("D1.input"))) {
	    	for (int i = 0; i < 100; i++) {
	       		cases[i] = Integer.parseInt(br.readLine());
    		}
		} catch (Exception e){
			System.out.println(e);
		}

		int answers[] = new int[100];
		int total = 0;

		for (int i = 0; i < 100; i++){
			// Java always rounds down in the case of integer division, so we do not need to implement this
			int a = cases[i]/3;

			a -= 2;

			total += a;
		}

		System.out.println(total);
    }
}