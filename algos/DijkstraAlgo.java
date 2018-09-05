package com.au.algos;

import java.util.ArrayList;
import java.util.List;

public class DijkstraAlgo {

    public List< Node > getShortestPath(Node startNode, int graphSize) {
        List < Node > shortestPath = new ArrayList<>();

        int visitedCount = 0;
        Node currentNode = startNode;
        while (visitedCount < graphSize) {
            Node nextShortestDistanceNode = null;
            int nextShortestDistance = Integer.MAX_VALUE;
            for (Edge edge : currentNode.edges) {
                Node neighbourNode = edge.getNeighbourOf(currentNode);

                if (!neighbourNode.visited) {
                    // Calculate shortest distance
                    int shortestDistance = currentNode.shortestDistance + edge.distance;
                    //then update the neighbour node
                    if (shortestDistance < neighbourNode.shortestDistance) {
                        neighbourNode.shortestDistance = shortestDistance;
                        neighbourNode.prevNode = currentNode;
                    }
                    if (shortestDistance < nextShortestDistance) {
                        nextShortestDistance = shortestDistance;
                        nextShortestDistanceNode = neighbourNode;
                    }
                }
            }
            currentNode.visited = true;
            visitedCount++;
            if (nextShortestDistanceNode != null) {
                currentNode = nextShortestDistanceNode;
            }
        }
        System.out.println("Shortest Path: " + currentNode.shortestDistance);
        StringBuilder pathBuilder = new StringBuilder("");
        while (currentNode != null) {
            pathBuilder.append(" <- ").append(currentNode.name);
            shortestPath.add(0, currentNode);
            currentNode = currentNode.prevNode;
        }
        System.out.println(pathBuilder.toString());
        return shortestPath;
    }

    private static class Node {
        String name;
        int shortestDistance = Integer.MAX_VALUE; //Infinity
        Node prevNode;
        boolean visited;
        List < Edge > edges = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, Edge ...edges) {
            this.name = name;
            for (Edge edge : edges) {
                this.edges.add(edge);
            }
        }

        public Node(String name, int shortestDistance) {
            this.name = name;
            this.shortestDistance = shortestDistance;
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        @Override
        public String toString() {
            String prevNodeName = this.prevNode != null? this.prevNode.name : "";
            return "[" + this.name + ", " + this.shortestDistance + ", " + prevNodeName + "]";
        }
    }

    private static class Edge {
        int distance;
        Node[] nodes;

        public Edge(int distance, Node ...nodes) {
            this.distance = distance;
            this.nodes = nodes;
            for (Node node: nodes) {
                node.addEdge(this);
            }
        }

        public Node getNeighbourOf(Node currNode) {
            if (nodes[0] == currNode) {
                return nodes[1];
            } else {
                return nodes[0];
            }
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A", 0);
        Node nodeB = new Node("B");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeC = new Node("C");

        Edge edge = null;
//        edge = new Edge(6, nodeA, nodeB);
//        edge = new Edge(1, nodeA, nodeD);
//        edge = new Edge(2, nodeD, nodeB);
//        edge = new Edge(1, nodeD, nodeE);
//        edge = new Edge(2, nodeB, nodeE);
//        edge = new Edge(5, nodeB, nodeC);
//        edge = new Edge(5, nodeE, nodeC);
        edge = new Edge(2, nodeA, nodeB);
        edge = new Edge(2, nodeC, nodeB);
        edge = new Edge(2, nodeD, nodeC);
        edge = new Edge(2, nodeE, nodeD);
        edge = new Edge(5, nodeA, nodeE);

        List < Node > shortestPath = new DijkstraAlgo().getShortestPath(nodeA, 5);
    }
}
