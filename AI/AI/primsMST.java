package AI;
import java.util.*;
public class primsMST {
	static final int V = 5;

	int minKey(int[] key, boolean[] mstSet){
		int min = Integer.MAX_VALUE , minIdx = -1;
		for(int  v = 0; v<V; v++){
			if(!mstSet[v] && key[v]<min){
				min = key[v];
				minIdx = v;
			}
		}
		return minIdx;
	}

	void primsmst(int[][] graph){
		int [] parent = new int[V];
		int [] key = new int[V];
		boolean [] mstSet = new boolean[V];

		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		parent[0] =-1;

		for(int x = 0 ; x < V-1; x++){
			int u = minKey(key,mstSet);
			mstSet[u] = true;


		}
	}
}
