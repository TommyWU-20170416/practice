package org.datastructuresandalgorithms.hiskio.tree;

/**
 * 沒有重複
 * -------5
 * ---2-------6
 * -1   4   X   7
 * X X 3 X X X X X
 * <p>
 * 有重複
 * -------5
 * ---2-------6
 * -2   4   6   7
 * 1-X X-X X-X X-X
 */
public class BST_TreeSort_List_Test {
    public static void main(String[] args) {
        /** insert */
//        int[] nums = {5, 2, 6, 1, 4, 7, 3};
        int[] nums = {5, 2, 2, 6, 6, 1, 4, 7, 3}; // duplicate
        BST_TreeSort_List bst = new BST_TreeSort_List(nums);
        bst.buildtree();
        bst.tree_sort_ascending(nums);
        System.out.println();
        bst.tree_sort_descending(nums);
        System.out.println();
    }
}
