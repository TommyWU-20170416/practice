package org.datastructuresandalgorithms.hiskio.tree;

public class BT_List_BFS_Test {
    public static void main(String[] args) {
        Integer[] nums = {
                5,
                2, 6,
                1, 4, null, 7,
                null, null, 3, null, null, null, null, null
        };

        BT_List_BFS bt = new BT_List_BFS(nums);
        bt.buildtree();
        System.out.println();
        // 創建出來的樣子
        //        5
        //    2       6
        //  1   4   X   7
        // X X 3 X X X X X

        /** test dfs left with preoder, inorder, postorder */
        System.out.print("bfs:  ");
        bt.traverse_levelorder_bfs();
    }
}
