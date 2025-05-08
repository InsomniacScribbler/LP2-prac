package AI;
import java.util.*;

public class practice{
	static class Edge{
		int vertex, weight;
		Edge(int v, int w){
			vertex= v;
			weight = w;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<List<Edge>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			adj.get(u).add(new Edge(v,w));
			adj.get(v).add(new Edge(u,w));
		}


		boolean [] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

		pq.offer(new Edge (0,0));
		int mstCost = 0;
		while(!pq.isEmpty()){
			Edge curr = pq.poll();
			int  u = curr.vertex;
			int w = curr.weight;
			if(visited[u]) continue;
			visited[u] = true;
			mstCost+=w;

			for(Edge neigbhor : adj.get(u)){
				if(!visited[neigbhor.vertex]){
					visited[neigbhor.vertex] = true;
					pq.offer(new Edge(neigbhor.vertex, neigbhor.weight));
				}
			}
		}
	}

}


