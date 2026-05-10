public class Experiment {

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            System.out.println("\n===== GRAPH SIZE: " + size + " =====");

            Graph g = new Graph();

            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size - 1; i++) {
                g.addEdge(i, i + 1);
            }

            if (size == 10) {
                g.printGraph();
            }

            runTraversals(g);
        }
    }

    public void runTraversals(Graph g) {
        long startBFS = System.nanoTime();
        g.bfs(0);
        long endBFS = System.nanoTime();

        long startDFS = System.nanoTime();
        g.dfs(0);
        long endDFS = System.nanoTime();

        System.out.println("BFS Time: " + (endBFS - startBFS) + " ns");
        System.out.println("DFS Time: " + (endDFS - startDFS) + " ns");
    }

    public void runDijkstraTest() {
        System.out.println("\n===== DIJKSTRA TEST =====");

        Graph g = new Graph();

        for (int i = 0; i < 5; i++) {
            g.addVertex(new Vertex(i));
        }

        g.addWeightedEdge(0, 1, 12);
        g.addWeightedEdge(0, 2, 5);
        g.addWeightedEdge(1, 2, 8);
        g.addWeightedEdge(1, 3, 15);
        g.addWeightedEdge(2, 3, 7);
        g.addWeightedEdge(2, 4, 20);
        g.addWeightedEdge(3, 4, 4);

        long start = System.nanoTime();
        g.dijkstra(0);
        long end = System.nanoTime();

        System.out.println("Dijkstra Time: " + (end - start) + " ns");
    }

    public void printResults() {
        System.out.println("\nExperiments completed successfully.");
    }
}