import java.util.Scanner;
import java.io.FileInputStream;

public class D3 {
    public static void main(String[] args) {

        int maxMoves = 300;

        // Magnitude of moves for wires A and B
        int movesA[] = new int[maxMoves];
        int movesB[] = new int[maxMoves];

        // Direction of moves for wires A and B
        char dirA[] = new char[maxMoves];
        char dirB[] = new char[maxMoves];

        // Read in the file
        readFile(movesA, movesB, dirA, dirB, maxMoves, "D3.input");

        // Calculate the max size of the maze/array
        calcBoardSize(movesA, movesB, dirA, dirB, maxMoves);

        // We use cases.clone() in part 1, as we do not want to affect the answers for part 2
        //System.out.println("Part 1 answer is: " + part1(cases.clone(), 12, 2));
        //System.out.println("Part 2 answer is: " + part2(cases));
        
    }

    public static void readFile(int[] movesA, int[] movesB, char[] dirA, char[] dirB, int maxMoves, String filename){
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            scanner.useDelimiter(",");
            
            for (int i = 0; i < maxMoves; i++){
                String move = scanner.next();
                dirA[i] = move.charAt(0);
                movesA[i] = move - move.subString(1);
            }

            for (int i = 0; i < maxMoves; i++){
                String move = scanner.next();
                dirB[i] = move.charAt(0);
                movesB[i] = move - move.subString(1);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static int[] calcBoardSize(int[] movesA, int[] movesB, char[] dirA, char[] dirB, int maxMoves){
        int maxX, maxY;

        int a = 0;

        for (int i = 0; i < maxMoves; i++){
            a = movesA[i]*convertToCoor(dirA[i]);
        }

        for (int i = 0; i < maxMoves; i++){
            
        }
    }

    public static int convertToCoor(char dir){
        switch(dir){
            case 'U':
            case 'R':
            return 1;
            break;
            case 'D':
            case 'L':
            default:
            return -1;
            break;
        }
    }

}