import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;
    private Map<Integer, List<int[]>> weightedAdjList;

    public Graph() {
        adjacencyList = new HashMap<>();
        weightedAdjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
        weightedAdjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    public void addWeightedEdge(int from, int to, int weight) {
        weightedAdjList.get(from).add(new int[]{to, weight});
        weightedAdjList.get(to).add(new int[]{from, weight});
    }

    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + ": ");
            for (int neighbor : adjacencyList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int size = weightedAdjList.size();
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {
            int min = Integer.MAX_VALUE;
            int current = -1;

            for (int j = 0; j < size; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            if (current == -1) break;
            visited[current] = true;

            for (int[] edge : weightedAdjList.get(current)) {
                int neighbor = edge[0];
                int weight = edge[1];

                if (!visited[neighbor]
                        && distance[current] != Integer.MAX_VALUE
                        && distance[current] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[current] + weight;
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < size; i++) {
            System.out.println("  To vertex " + i + " = " + distance[i]);
        }
    }
}