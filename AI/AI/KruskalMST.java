package AI;

import java.util.*;

public class KruskalMST {

	static List<Integer> parent;

	// Find with path compression
	static int findParent(int x) {
		if (parent.get(x) == x)
			return x;
		return findParent(parent.get(x));
	}

	// Union of two sets
	static void unionSet(int x, int y) {
		int parentX = findParent(x);
		int parentY = findParent(y);
		if (parentX != parentY)
			parent.set(parentX, parentY);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of Vertices: ");
		int v = sc.nextInt();
		System.out.print("Enter number of Edges: ");
		int e = sc.nextInt();

		List<int[]> edges = new ArrayList<>();
		parent = new ArrayList<>();

		// Initialize parent list
		for (int i = 0; i < v; i++) {
			parent.add(i);
		}

		// Input edges
		for (int i = 0; i < e; i++) {
			System.out.print("Enter Source, Destination, and Weight: ");
			int u = sc.nextInt();
			int v1 = sc.nextInt();
			int w = sc.nextInt();
			edges.add(new int[]{u, v1, w});
		}

		// Sort edges by weight
		edges.sort(Comparator.comparingInt(a -> a[2]));

		int mstCost = 0;

		// Kruskal's algorithm
		for (int[] edge : edges) {
			int u = edge[0];
			int v1 = edge[1];
			int weight = edge[2];

			int parentU = findParent(u);
			int parentV = findParent(v1);

			if (parentU != parentV) {
				unionSet(u, v1);
				mstCost += weight;
			}
		}

		System.out.println("Minimum Spanning Tree Cost: " + mstCost);
		sc.close();
	}
}

