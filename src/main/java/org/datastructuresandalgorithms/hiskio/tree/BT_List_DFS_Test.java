package org.datastructuresandalgorithms.hiskio.tree;

public class BT_List_DFS_Test {
    public static void main(String[] args) {
        Integer[] nums = {
                5,
                2, 6,
                1, 4, null, 7,
                null, null, 3, null, null, null, null, null
        };

        BT_List_DFS bt = new BT_List_DFS(nums);
        bt.buildtree();
        System.out.println();
        // 創建出來的樣子
        //        5
        //    2       6
        //  1   4   X   7
        // X X 3 X X X X X

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
