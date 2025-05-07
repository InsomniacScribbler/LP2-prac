package AI;
import java.util.*;

public class primsMST {

	// Edge class to represent destination and weight
	static class Edge {
		int vertex, weight;

		Edge(int v, int w) {
			vertex = v;
			weight = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of Vertices: ");
		int V = sc.nextInt();



		System.out.print("Enter number of Edges: ");
		int E = sc.nextInt();

		// Initialize adjacency list
		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		// Read edges
		for (int i = 0; i < E; i++) {
			System.out.print("Enter Source, Destination, and Weight: ");
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();



			// Add edge to both source and destination (undirected graph)
			adj.get(u).add(new Edge(v, w));
			adj.get(v).add(new Edge(u, w));
		}

		// Prim's Algorithm to find MST
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		int mstCost = 0;

		// Start from vertex 0
		pq.offer(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int u = current.vertex;
			int weight = current.weight;

			if (visited[u]) continue;

			visited[u] = true;
			mstCost += weight;

			for (Edge neighbor : adj.get(u)) {
				if (!visited[neighbor.vertex]) {
					pq.offer(new Edge(neighbor.vertex, neighbor.weight));
				}
			}

		}

		System.out.println("Minimum Spanning Tree Cost: " + mstCost);
		sc.close();
	}
}
