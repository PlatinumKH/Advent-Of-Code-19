package Day3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class D3 {
	
	public static void main(String[] args) {

		Node origin = new Node(0, 0, 0);
		Path[] paths = new Path[2];

		readFile(paths, "D3.input");
		   
		System.out.println("Part one answer is: " + part1(paths, origin));
		System.out.println("Part two answer is: " + part2(paths, origin));
	}

	public static void readFile(Path[] paths, String filename){
		try (Stream<String> stream = Files.lines(Paths.get(filename))) {
			String[] temp = stream.toArray(String[]::new);
			
			paths[0] = new Path();
			paths[0].buildPath(temp[0].split(","));
			
			paths[1] = new Path();
			paths[1].buildPath(temp[1].split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int part1(Path[] paths, Node origin){
		List<Node> intersections = paths[0].findIntersections(paths[1]);
		List<Integer> distances = intersections.stream()
						        .map(node -> Path.findManhattanDistance(origin, node))
						        .collect(Collectors.toList());
		distances.sort((a, b) -> { return a - b; });
		return distances.get(0);
	}

	public static int part2(Path[] paths, Node origin){
		List<Node> intersections = paths[0].findIntersections(paths[1]);
		List<Integer> distances = intersections.stream()
						        .map(node -> node.length)
						        .collect(Collectors.toList());
		distances.sort((a, b) -> { return a - b; });
						        
		return distances.get(0);
	}
	
}