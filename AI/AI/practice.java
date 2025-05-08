package AI;
import java.util.*;

public class practice{
	Map<Integer, List<Integer>> graph = new HashMap<>();

	public void addEdge(int u, int v){
		graph.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
		graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
	}

	public void dfs(int node, Set<Integer> visited){
		visited.add(node);
		System.out.println(node+" ");

		for (int neighbour : graph.getOrDefault(node, new ArrayList<>())){
			if(!visited.contains(neighbour)){
				dfs(neighbour, visited);
			}
		}
	}

	public void startDFS(int startnode){
		Set<Integer> visited = new HashSet<>();
		System.out.println("DFS:");
		dfs(startnode,visited);
		System.out.println();
	}

	public void startBFS(int startnode){
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		visited.add(startnode);
		queue.offer(startnode);
		System.out.println("BFS:");

		while(!queue.isEmpty()){
			int current = queue.poll();
			System.out.println(current + " ");
			for(int neighbour : graph.getOrDefault(current , new ArrayList<>())){
				if((!visited.contains(neighbour))){
					visited.add(neighbour);
					queue.offer(neighbour);
				}
			}
			System.out.println();
		}
	}

}