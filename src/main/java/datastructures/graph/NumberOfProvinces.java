import java.util.*;

/**
 * @author Francisco Franco
 *
 * There are n cities. A province is a group of directly or indirectly 
 * connected cities and no other cities outside of the group. You are 
 * given an n x n matrix isConnected where isConnected[i][j] = isConnected[j][i] = 1 
 * if the i th city and the j th city are directly connected, and 
 * isConnected[i][j] = 0 otherwise. Return the total number of provinces.
 *
 * Time Complexity: DFS usually O(n+e) but O(n^2) for ths problem
 *                  where n is number of nodes and e is number of edges
 * Space Complexity: O(n+e)
 */

public class NumberOfProvinces {
	// Graph to store city and connected cities list
	Map<Integer, List<Integer>> graph = new HashMap<>();
	
	// Use seen array to avoid cycles
	boolean[] seen;

	// Use seen array to avoid cycles
	Set<Integer> seenItr;
	
	// Get city id
	private int getCityId(int nodeIndex) {
		return nodeIndex + 1;
	}
	
	// Print graph
	private void printGraph(Map<Integer, List<Integer>> graph) {
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			List<Integer> neighbors = entry.getValue();
			if (!neighbors.isEmpty()) {
				for (Integer neighbor : neighbors) {
					// DEBUG 
					System.out.println("city: " + getCityId(entry.getKey()) + " neighbor: " + getCityId(neighbor));
				}
			}
			else {
				// DEBUG
				System.out.println("city: " + getCityId(entry.getKey()) + " " + neighbors);
			}
		}
	}

	// Check each city/node's neighbors
	// if they are connected from graph
	// HashMap using ArrayList value
	private void dfsRecursive(int node) {
		for (int neighbor: graph.get(node)) {
			// DEBUG
			System.out.println("DFS city: " + getCityId(node) + " neighbor: " + getCityId(neighbor));
			if (!seen[neighbor]) {
				seen[neighbor] = true;
				dfsRecursive(neighbor);            
			}
		}
	}

	// Check each city/node's neighbors
	// if they are connected from graph
	// HashMap using ArrayList value
	public void dfsIterative(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while (!stack.empty()) {
			int node = stack.pop();
			for (int neighbor: graph.get(node)) {
				if (!seenItr.contains(neighbor)) {
					seenItr.add(neighbor);
					stack.push(neighbor);
				}
			}
		}
	}
	
	// isConnected is adjacency matrix
	// 2D array/matrix isConnected contains the nodes
	// isConnected[i][j] == 1 means there is an outgoing edge from node i to node j
	public int findNumberOfConnectedComponents(int[][] isConnected) {
		// Number of nodes
		int n = isConnected.length;
		// DEBUG
		System.out.println("n: " + n);
		System.out.println("================");
		for (int i = 0; i < n; i++) {
			// DEBUG
			System.out.println("i: " + i);
			// Store array list of cities 
			// connected to node/city i
			if (!graph.containsKey(i)) {
				graph.put(i, new ArrayList<>());
			}
			for (int j = i + 1; j < n; j++) {
				// DEBUG
				System.out.println("j: " + j);
				// Since graph is undirected
				// need to store array list of cities
				// connected to city/node j 
				if (!graph.containsKey(j)) {
					graph.put(j, new ArrayList<>());
				}
				if (isConnected[i][j] == 1) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
			// DEBUG
			System.out.println("================");
		}
		
		// DEBUG
		printGraph(graph);
		
		// DEBUG
		System.out.println("================");
		
		seen = new boolean[n];
		seenItr = new HashSet<>();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!seen[i]) {
				//if (!seenItr.contains(i))  {
				// Add all nodes of a connected component to the set
				ans++;
				//seenItr.add(i);
				seen[i] = true;
				// DEBUG
				System.out.println("ABOUT TO INVOKE DFS with city: " + getCityId(i));
				dfsRecursive(i);
				//dfsIterative(i);
			}
		}
		return ans;
	}
	
	// Driver code
	public static void main(String[] args) {
		//int[][] connectedCities = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] connectedCities = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		NumberOfProvinces numOfProvinces = new NumberOfProvinces();
		int numProvinces = numOfProvinces.findNumberOfConnectedComponents(connectedCities);
		System.out.println("Number of Provinces: " + numProvinces); 
	}
}
