package org.datastructuresandalgorithms.hiskio.tree;

/**
 * 使用 array 練習 binary tree
 */
public class BT_Array {
    private Integer[] nums;

    public BT_Array(Integer[] nums) {
        this.nums = nums;
    }

    /** 實做 DFS left */
    public void traverse_left_preorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_left_preorder(i_root);
    }
    private void traverse_left_preorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        if (nums[index] != null) System.out.print(this.nums[index] + " ");
        traverse_left_preorder(i_left);
        traverse_left_preorder(i_right);
    }
    public void traverse_left_inorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_left_inorder(i_root);
    }
    private void traverse_left_inorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        traverse_left_inorder(i_left);
        if (nums[index] != null) System.out.print(this.nums[index] + " ");
        traverse_left_inorder(i_right);
    }
    public void traverse_left_postorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_left_postorder(i_root);
    }
    private void traverse_left_postorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        traverse_left_postorder(i_left);
        traverse_left_postorder(i_right);
        if (nums[index] != null) System.out.print(this.nums[index] + " ");
    }

    /** 實做 DFS right */
    public void traverse_right_preorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_right_preorder(i_root);
    }
    private void traverse_right_preorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        if (nums[index] != null) System.out.print(this.nums[index] + " ");
        traverse_right_preorder(i_right);
        traverse_right_preorder(i_left);
    }
    public void traverse_right_inorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_right_inorder(i_root);
    }
    private void traverse_right_inorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        traverse_right_inorder(i_right);
        if (nums[index] != null) System.out.print(this.nums[index] + " ");
        traverse_right_inorder(i_left);
    }
    public void traverse_right_postorder() {
        if (this.nums.length < 0) return;
        int i_root = 0;
        if (nums[i_root] == null) return;
        traverse_right_postorder(i_root);
    }
    private void traverse_right_postorder(Integer index) {
        if (index >= this.nums.length) return;
        int i_left = (index + 1) * 2 - 1;
        int i_right = (index + 1) * 2;

        traverse_right_postorder(i_right);
        traverse_right_postorder(i_left);
        if (nums[index] != null) System.out.print(this.nums[index] + " ");
    }
}
