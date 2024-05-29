package org.datastructuresandalgorithms.hiskio.tree;

public class BST_SortedArray_Test {
    public static void main(String[] args) {
        // 這樣分法會是
        // 0 - 4 - 9
        // 此時如果是 search_leftmost 因為剛好 0 - 4 的最右邊是44，而這個 44 繼續往左不會有東西，所以只會找到一次
        // search_rightmost 則會找到多次 more right result

        Integer[] nums = {0, 11, 22, 33, 44, 44, 44, 44, 44, 55};
        BST_SortedArray bst = new BST_SortedArray(nums);

        Integer node_found = bst.search(22);
        System.out.println(node_found == null ? "Not found" : "found: " + node_found);

        node_found = bst.search(44);
        System.out.println(node_found == null ? "Not found" : "found: " + node_found);

        Integer node_found_left_most = bst.search_leftmost(44);
        System.out.println(node_found == null ? "Not found" : "found: " + node_found_left_most);

        Integer node_found_right_most = bst.search_rightmost(44);
        System.out.println(node_found == null ? "Not found" : "found: " + node_found_right_most);
    }
}
