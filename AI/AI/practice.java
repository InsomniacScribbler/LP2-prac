package AI;

import java.util.*;

public class practice {
	static class Edge{
		int vertex, weight;
		Edge(int v, int w){
			this.vertex = v;
			this.weight = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<List<Edge>> adj = new ArrayList<>();
		System.out.println("Enter the no of vertices:");
		int V = sc.nextInt();
		for(int i=0; i<V;i++){
			adj.add(new ArrayList<>());
		}
		System.out.println("Enter the no of edges:");
		int E = sc.nextInt();

		for(int i = 0 ; i<E; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			adj.get(u).add(new Edge(v,w));
			adj.get(u).add(new Edge(u,w));
		}

		boolean [] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e ->e.weight)) ;
		int mstcost = 0;

		pq.offer(new Edge(0,0));

		while(!pq.isEmpty()){
			Edge current = pq.poll();
			int  u = current.vertex;
			int w = current.weight;

			if(visited[u]) continue;

			visited[u] = true;
			mstcost+=w;

			for(Edge neighbour : adj.get(u)){
				if(!visited[neighbour.vertex]){
					pq.offer(new Edge(neighbour.vertex, neighbour.weight));
				}
			}
		}

	}

}
