package org.datastructuresandalgorithms.hiskio.tree;

public class BT_Array_Test {
    public static void main(String[] args) {
        Integer[] nums = {
                5,
                2, 6,
                1, 4, null, 7,
                null, null, 3, null, null, null, null, null
        };

        BT_Array bt = new BT_Array(nums);

        /** test dfs left with preoder, inorder, postorder */
        System.out.print("preorder:  ");
        bt.traverse_left_preorder();
        System.out.print("\ninorder:   ");
        bt.traverse_left_inorder();
        System.out.print("\npostorder: ");
        bt.traverse_left_postorder();

        /** test dfs right with preoder, inorder, postorder */
        System.out.print("\npreorder:  ");
        bt.traverse_right_preorder();
        System.out.print("\ninorder:   ");
        bt.traverse_right_inorder();
        System.out.print("\npostorder: ");
        bt.traverse_right_postorder();
    }

}
