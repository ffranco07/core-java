import java.util.*;

/**
 * @author Francisco Franco
 *
 * There is a bi-directional graph with n vertices, where each vertex 
 * is labeled from 0 to n - 1 (inclusive). The edges in the graph are 
 * represented as a 2D integer array edges, where each edges[i] = [ui, vi] 
 * denotes a bi-directional edge between vertex ui and vertex vi. Every 
 * vertex pair is connected by at most one edge, and no vertex has an edge 
 * to itself.
 * You want to determine if there is a valid path that exists from vertex 
 * source to vertex destination.
 * Given edges and the integers n, source, and destination, return true if 
 * there is a valid path from source to destination, or false otherwise.
 * 
 * Approach 1: Breadth First Search (BFS) Algorithm
 * 1. Initialize an empty queue (queue) to store the nodes to be visited.
 * 2. Use one boolean array "seen" to mark all visited nodes and hash map 
 *    graph to store all edges.
 * 3. Add the starting node 0 to queue and mark it as visited.
 * 4. If queue has nodes, get the first node curr_node from queue. Return 
 *    true if curr_node is destination, otherwise, go to step 5.
 * 5. Add all unvisited neighbor nodes of curr_node to queue and mark them 
 *    as visited, then repeat step 4.
 * 6. If we emptied queue without finding destination, return false.
 * 
 * Complexity Analysis:
 * Let n be the number of nodes and m be the number of edges.
 * Time complexity: O(n+m)
 * In a typical BFS search, the time complexity is O(V+E) 
 * where V is the number of vertices and E is the number of edges. 
 * There are n nodes and m edges in this problem.
 * We build adjacent list of all m edges in graph which takes O(m).
 * Each node is added to the queue and popped from queue once, it takes O(n) 
 * to handle all nodes.
 * Space complexity: O(n+m)
 * We used a hash map neighbors to store all edges, which requires O(m) space 
 * for m edges.
 * We use seen, either a hash set or an array to record the visited nodes, which 
 * takes O(n) space.
 * There may be up to n nodes stored in queue and O(n) space is required.
 * Therefore, the space complexity is O(n+m).
 */

public class FindPathInGraph {
	// Store all edges in graph
	Map<Integer, List<Integer>> graph = null;
	
	// Boolean array to mark neighbors as seen/visited
	boolean[] seen;
	
	// Store all the nodes to be visited in queue
	Queue<Integer> queue = null;
	
	private static String getEdgesAsString(int[][] edges) {
		int i, j;
		int rows = edges.length;
		int columns = edges[0].length;
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (i = 0; i < rows; i++) {
			builder.append("{");
			for (j = 0; j < columns; j++) {
				builder.append(edges[i][j]);
				
				if (j != (columns - 1)) {
					builder.append(", ");
				}
			}
			builder.append("}");
			if (i != (rows - 1)) {
				builder.append(", ");
			}
		}
		builder.append("}");
		return builder.toString();
	}
	
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		graph = new HashMap<>();
		
		int u, v;
		for (int[] edge: edges) {
			u = edge[0];
			v = edge[1];
			// If the specified key is not already associated with a value (or is mapped to null), 
			// attempts to compute its value using the given mapping function and enters it into 
			// this map unless null. So u or v will be passed as val and used as key.
			graph.computeIfAbsent(u, val -> new ArrayList<Integer>()).add(v);
			graph.computeIfAbsent(v, val -> new ArrayList<Integer>()).add(u);
		}
		
		seen = new boolean[n];
		seen[source] = true;
		
		queue = new LinkedList<>();
		queue.offer(source);
		
		int currNode;
		while (!queue.isEmpty()) {
			currNode = queue.poll();
			if (currNode == destination) {
				return true;
			}
			
			// For all the neighbors of the current node, if we haven't visited it before,
			// then add it to queue and mark it as visited
			for (int nextNode : graph.get(currNode)) {
				if (!seen[nextNode]) {
					seen[nextNode] = true;
					queue.offer(nextNode);
				}
			}
		}
		return false;
	}
	
	// Driver code
	public static void main(String[] args) {
		//int nodes = 3;
		int nodes = 6;
		//int[][] edges = {{0,1},{1,2},{2,0}};
		int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
		//int source = 0, destination = 2;
		int source = 0, destination = 5;
		FindPathInGraph findPathInGraph = new FindPathInGraph();
		// DEBUG
		System.out.println("nodes: " + nodes + " edges: " + findPathInGraph.getEdgesAsString(edges) + " source: " + source + " destination: " + destination);
		boolean pathFound = findPathInGraph.validPath(nodes, edges, source, destination);
		System.out.println("pathFound: " + pathFound); 
	}
}
