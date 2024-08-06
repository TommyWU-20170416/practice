package org.datastructuresandalgorithms.hiskio.graph.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * https://hiskio.com/courses/458/lectures/135117
 * 透過 union find 去找出是否 (有 loop 或是烙單的 node) 沒有的話就是一個 tree
 */

public class Graph_ValidTree {
    Map<Integer, Integer> node2root = new HashMap<>(); // 紀錄 每個節點的根結點

    public static void main(String[] args) {

//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 4}};  // OK case
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 3}};  // failed case
        int num_of_nodes = 5;

        Graph_ValidTree vt = new Graph_ValidTree();
        boolean is_valid_tree = vt.is_valid_tree(num_of_nodes, edges);
        System.out.println();
    }

    private boolean is_valid_tree(int num_of_nodes, int[][] edges) {

        if (edges.length != (num_of_nodes - 1)) return false; // 節點數 不等於 相連線 - 1 代表有烙單

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            int left = edge[0];
            int right = edge[1];

            // 把節點加入到 union find
            add(left);
            add(right);

            // 加入的時候如果有 loop
            if (is_connected(left, right)) return false;

            // 把兩個結合在一起
            union(left, right);
        }
        return true;
    }

    // 假設是 add 不loop的兩個，add 後因為 自己就是自己的 root 所以會是不同群，不同群之後就會 union 合併，你是我的 root
    private void union(Integer left, Integer right) {
        Integer root_left = find_root(left);
        Integer root_right = find_root(right);

        if (root_left.equals(root_right)) return; // 如果找出來是同一群，就不用再做其他事情

        node2root.put(root_left, root_right); // take right one's root as the common root
    }

    private void add(Integer node) {
        if (node2root.containsKey(node)) return;
        node2root.put(node, node); // 讓自己成為自己的 root
    }

    // 找出兩個節點的 root 然後再去看是否一樣，一樣代表有關聯
    // 但如果壓縮後跟節點都一樣 不就都回傳 true ???
    private boolean is_connected(Integer left, Integer right) {
        Integer root_left = find_root(left);
        Integer root_right = find_root(right);

        if (root_left.equals(root_right)) return true;

        return false;
    }

    private Integer find_root(Integer node) {
        Integer root_now = node2root.get(node);
        if (root_now.equals(node)) return node;

        Integer root_final = find_root(root_now);
        node2root.put(node, root_final); // 如果 node 有三層才到 root(1 > 2 > 3)。 這樣 node2root 內是不是會有多兩個，原本的(1, 1)(1, 2)(1, 3) ???

        return root_final;
    }
}
