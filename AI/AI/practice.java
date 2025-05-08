package AI;
import java.util.*;
public class practice{
	static class Edge{
		int vertex, weight;
		Edge(int v, int w){
			vertex = v;
			weight = w;

		}
	}

	public static void dijkstra(List<List<Edge>> adj, int source, int V){
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));
		pq.offer(new Edge(source, 0));

		while(!pq.isEmpty()){
			Edge curr = pq.poll();
			int u = curr.vertex;
			for(Edge neighbour : adj.get(u)){
				int v = neighbour.vertex;
				int w = neighbour.weight;

				if(dist[u] + w < dist[v]){
					dist[v] = dist[u] + w;
					pq.offer(new Edge(v,dist[v]));
				}
			}
		}
	}
}


