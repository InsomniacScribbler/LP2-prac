package AI;

import java.util.*;

public class DijkstraSSSP {

	static class Edge {
		int vertex, weight;
		Edge(int v, int w) {
			vertex = v;
			weight = w;
		}
	}

	public static void dijkstra(List<List<Edge>> adj, int source, int V) {
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		pq.offer(new Edge(source, 0));

		while (!pq.isEmpty()) {
			Edge current = pq.poll();
			int u = current.vertex;

			for (Edge neighbor : adj.get(u)) {
				int v = neighbor.vertex;
				int weight = neighbor.weight;

				if (dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pq.offer(new Edge(v, dist[v]));
				}
			}
		}

		System.out.println("Shortest distances from source " + source + ":");
		for (int i = 0; i < V; i++) {
			System.out.println("To vertex " + i + " -> Distance: " + dist[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of Vertices: ");
		int V = sc.nextInt();

		System.out.print("Enter number of Edges: ");
		int E = sc.nextInt();

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			System.out.print("Enter Source, Destination, and Weight: ");
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj.get(u).add(new Edge(v, w));
			adj.get(v).add(new Edge(u, w)); // For undirected graph; remove for directed
		}

		System.out.print("Enter source vertex: ");
		int source = sc.nextInt();

		dijkstra(adj, source, V);
		sc.close();
	}
}
