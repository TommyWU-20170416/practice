package org.datastructuresandalgorithms.hiskio.tree;

/**
 * 練習 preorder, inorder, postorder
 */
public class BT_List_DFS {
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

    public BT_List_DFS(Integer[] nums) {
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

    /** 實做 DFS left */
    public void traverse_left_preorder() {
        if (this.root == null) return;
        traverse_left_preorder(this.root);
    }
    private void traverse_left_preorder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        traverse_left_preorder(node.left);
        traverse_left_preorder(node.right);
    }
    public void traverse_left_inorder() {
        if (this.root == null) return;
        traverse_left_inorder(this.root);
    }
    private void traverse_left_inorder(Node node) {
        if (node == null) return;
        traverse_left_inorder(node.left);
        System.out.print(node.val + " ");
        traverse_left_inorder(node.right);
    }
    public void traverse_left_postorder() {
        if (this.root == null) return;
        traverse_left_postorder(this.root);
    }
    private void traverse_left_postorder(Node node) {
        if (node == null) return;
        traverse_left_postorder(node.left);
        traverse_left_postorder(node.right);
        System.out.print(node.val + " ");
    }

    /** 實做 DFS right */
    public void traverse_right_preorder() {
        if (this.root == null) return;
        traverse_right_preorder(this.root);
    }
    private void traverse_right_preorder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        traverse_right_preorder(node.right);
        traverse_right_preorder(node.left);
    }
    public void traverse_right_inorder() {
        if (this.root == null) return;
        traverse_right_inorder(this.root);
    }
    private void traverse_right_inorder(Node node) {
        if (node == null) return;
        traverse_right_inorder(node.right);
        System.out.print(node.val + " ");
        traverse_right_inorder(node.left);
    }
    public void traverse_right_postorder() {
        if (this.root == null) return;
        traverse_right_postorder(this.root);
    }
    private void traverse_right_postorder(Node node) {
        if (node == null) return;
        traverse_right_postorder(node.right);
        traverse_right_postorder(node.left);
        System.out.print(node.val + " ");
    }
}
