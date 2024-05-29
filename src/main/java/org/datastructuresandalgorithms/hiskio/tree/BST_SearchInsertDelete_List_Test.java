package org.datastructuresandalgorithms.hiskio.tree;

/**
 * ------5
 * --2       6
 * 1   4   X   7
 * X X 3 X X X X X
 */
public class BST_SearchInsertDelete_List_Test {
    public static void main(String[] args) {
        /** insert */
        int[] nums = {5, 2, 6, 1, 4, 7, 3};
        BST_SearchInsertDelete_List bst = new BST_SearchInsertDelete_List(nums);
        bst.buildtree();
        System.out.println();

        /** delete */
        // X    X
//        bst.delete(7);
        // left X
//        bst.delete(6);
        // X    right
//        bst.delete(4);
        // left right
//        bst.delete(2);
        // left root
//        bst.delete(5);

        /** search */
        BST_SearchInsertDelete_List.BST_Node node_found = null;
        node_found = bst.search(2);
        System.out.println("found: " + ((node_found != null) ? node_found.val : "not found"));
        node_found = bst.search(7);
        System.out.println("found: " + ((node_found != null) ? node_found.val : "not found"));
        node_found = bst.search(10);
        System.out.println("found: " + ((node_found != null) ? node_found.val : "not found"));
    }
}
