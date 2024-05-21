package org.datastructuresandalgorithms.hiskio.tree;

public class BT_Array_BFS_Test {
    public static void main(String[] args) {
        Integer[] nums = {
                5,
                2, 6,
                1, 4, null, 7,
                null, null, 3, null, null, null, null, null
        };

        BT_Array_BFS bt = new BT_Array_BFS(nums);

        /** test dfs left with preoder, inorder, postorder */
        System.out.print("bfs:  ");
        bt.traverse_levelorder_bfs();
    }

}
