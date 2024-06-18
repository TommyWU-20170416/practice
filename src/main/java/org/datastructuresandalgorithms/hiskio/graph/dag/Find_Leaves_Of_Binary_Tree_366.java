package org.datastructuresandalgorithms.hiskio.graph.dag;

import java.util.ArrayList;
import java.util.List;

/**
 * https://hiskio.com/courses/458/lectures/140343
 * 因為這題要 leetcode premium 才可以用，所以去看課程講解
 *
 * @author AaronWU
 * @created 創建時間：2024/06/18 10:36:10
 * @since JDK8.0
 */
public class Find_Leaves_Of_Binary_Tree_366 {
    public static void main(String[] args) {
        Find_Leaves_Of_Binary_Tree_366 s = new Find_Leaves_Of_Binary_Tree_366();
        Find_Leaves_Of_Binary_Tree_366.Solution solution = s.new Solution();

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        List<List<Integer>> result = solution.findLeaves(root);

        System.out.println("result: " + result);
    }


    class Solution {
        //     1     ==> level 2
        //    / \
        //   2   3   ==> level 1, relatively node 3 is in level 0
        //  /\
        // 4  5      ==> level 0
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            dfs(root);
            return lists;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            int level_left = dfs(node.left);
            int level_right = dfs(node.right);

            // when it did to the node 1
            // the left level would be 2
            // the right level would be 1
            // to locate the current node, it uses the Math.max
            // so the node 1 level is 2
            int level_max = Math.max(level_left, level_right);

            // checked: if size == level_max == last level, it means lists have to add new list
            // when level_max = 0, size must be 1, so that can add
            if (lists.size() == level_max) {
                lists.add(new ArrayList<>());
            }
            List<Integer> list = lists.get(level_max);
            list.add(node.val);

            return level_max + 1;
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}