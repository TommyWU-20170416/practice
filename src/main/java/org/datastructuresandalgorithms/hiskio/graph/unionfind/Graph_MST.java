package org.datastructuresandalgorithms.hiskio.graph.unionfind;

import java.util.*;

/**
 * https://hiskio.com/courses/458/lectures/135120
 * MST(Minimum Spanning Tree) 最小生成樹
 */
public class Graph_MST {
    // core data structure for union find
    Map<String, String> node2root = new HashMap<>();

    public static void main(String[] args) {

        Edge[] edges_info = new Edge[]{
                new Edge("A", "B", 1),
                new Edge("B", "C", 2),
                new Edge("A", "C", 3),
                new Edge("A", "D", 7),
                new Edge("C", "F", 9),
                new Edge("D", "E", 1),
                new Edge("E", "F", 4),
                new Edge("D", "F", 5)};

        Graph_MST gmst = new Graph_MST();
        List<Edge> mst = gmst.get_mst(edges_info);

        System.out.println();
    }

    private void union(String left, String right) {
        String root_left = find_root(left);
        String root_right = find_root(right);

        if (root_left.equals(root_right)) return;

        node2root.put(root_left, root_right); // take right one's root as the common root
    }

    private boolean is_connected(String left, String right) {

        String root_left = find_root(left);
        String root_right = find_root(right);

        if (root_left.equals(root_right)) return true;

        return false;
    }

    private String find_root(String node) {

        String root_now = node2root.get(node);
        if (root_now.equals(node)) return node;

        String root_final = find_root(root_now);
        node2root.put(node, root_final);

        return root_final;
    }

    private void add(String node) {
        if (node2root.containsKey(node)) return;
        node2root.put(node, node);  // initialization: be it's own root
    }

    public static class Edge {
        String node1;
        String node2;
        Integer cost;

        public Edge(String node1, String node2, Integer cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }

    public static class MyComp implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return e1.cost - e2.cost;
        }
    }

    private List<Edge> get_mst(Edge[] edges_info) {
        List<Edge> edges_picked = new ArrayList<>();

        Set<String> nodes = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(new MyComp());

        for (int i = 0; i < edges_info.length; i++) {
            Edge e = edges_info[i];

            nodes.add(e.node1);
            nodes.add(e.node2);

            pq.offer(e);

        }

        while (true) {
            if (pq.size() == 0) break;

            Edge e = pq.poll();

            add(e.node1);
            add(e.node2);

            if (is_connected(e.node1, e.node2)) {
                System.out.printf("skipped (%s->%s)%n", e.node1, e.node2);
                continue;
            }

            union(e.node1, e.node2);
            edges_picked.add(e);

            System.out.printf("used (%s->%s)%n", e.node1, e.node2);

        }

        if (edges_picked.size() != (nodes.size() - 1)) return null;

        return edges_picked;
    }


}
