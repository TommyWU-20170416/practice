package org.datastructuresandalgorithms.hiskio.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 練習 preorder, inorder, postorder
 */
public class BT_List_BFS {
    private Integer[] nums;
    private Node root;

    public static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public BT_List_BFS(Integer[] nums) {
        this.nums = nums;
    }

    // 非本章學習重點(本方法僅模擬測試資料用）
    public void buildtree() {
        if (this.nums.length < 0) return;
        if (this.nums[0] == null) return;

        // prepare Node instances
        Node[] nodes_tmp = new Node[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == null) continue;
            nodes_tmp[i] = new Node(this.nums[i]);
        }
        // set root
        this.root = nodes_tmp[0];

        for (int i = 0; i < this.nums.length; i++) {
            int i_left = (i + 1) * 2 - 1; // i_left_plus_one = (i_node_plus_one) * 2 -> i_left = i_left_plus_one - 1
            int i_right = (i + 1) * 2 + 1 - 1; // i_right_plus_one = (i_node_plus_one) * 2 + 1-> i_right = i_right_plus_one - 1

            Node node = nodes_tmp[i];
            if (node == null) continue;

            if (i_left < this.nums.length) {
                node.left = nodes_tmp[i_left];
            }
            if (i_right < this.nums.length) {
                node.right = nodes_tmp[i_right];
            }
        }
    }

    /**
     * 實做 BFS，借助 queue 先進先出的概念
     */
    public void traverse_levelorder_bfs() {
        if (this.root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (true) {
            if (queue.size() == 0) break;

            Node node = queue.poll();
            if (node == null) continue;
            System.out.print(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }
}