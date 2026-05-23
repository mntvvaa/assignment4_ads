# Bonus Task — Dijkstra's Algorithm (Shortest Path)

## Description

This is a bonus task where I implemented **Dijkstra's Algorithm** to find the shortest path from a starting vertex to all other vertices in a weighted graph.

## What I Did

To complete this task, I extended the basic graph structure:

- Added a `weight` field to the `Edge` class
- Modified the `Graph` class to store **weighted edges** using an adjacency list (`LinkedList<Edge>[]`)
- Implemented the `dijkstra(int start)` method

## How the Algorithm Works

Dijkstra's algorithm finds the shortest distances from a source vertex to all other vertices. Here's the general idea:

1. Set the distance to the start vertex as `0`, and all others as `infinity` (`Integer.MAX_VALUE`)
2. On each iteration, pick the **unvisited vertex with the smallest known distance**
3. For each of its neighbors, check if going through the current vertex gives a shorter path — if yes, update the distance
4. Mark the current vertex as visited and repeat until all vertices are processed

I used a simple loop instead of a priority queue (as allowed by the task requirements).
## Example

```java
Graph graph = new Graph(5);

graph.addEdge(0, 1, 12);
graph.addEdge(0, 2, 5);
graph.addEdge(1, 2, 8);
graph.addEdge(1, 3, 15);
graph.addEdge(2, 3, 7);
graph.addEdge(2, 4, 20);
graph.addEdge(3, 4, 4);

graph.dijkstra(0);
```
**Output:**
<img width="1280" height="800" alt="0e7dd5f8-f0cb-4c3f-8b7b-b66982102d64" src="https://github.com/user-attachments/assets/606339bf-27a7-49e7-8d1c-8112ea4edaf9" />

## Conclusion
Dijkstra Algorithm was successfully implemented and tested on a weighted graph.
