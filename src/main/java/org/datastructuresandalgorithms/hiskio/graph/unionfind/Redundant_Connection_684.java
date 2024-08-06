package org.datastructuresandalgorithms.hiskio.graph.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 684.https://leetcode.com/problems/redundant-connection/description/
 *
 * @author AaronWU
 * @created 創建時間：2024/08/06 15:44:26
 * @since JDK8.0
 */
public class Redundant_Connection_684 {
    public static void main(String[] args) {
        Redundant_Connection_684 ss = new Redundant_Connection_684();
        Redundant_Connection_684.Solution solution = ss.new Solution();

//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        int[] result = solution.findRedundantConnection(edges);
        System.out.println(result);
    }


    /**
     * Runtime: 1 ms, Beats 76.39%
     * 這題是要找出在這個 graph 中移除掉誰可以成一個 tree
     * 也就是把連成環的那一條移除
     * 所以使用 union find 去找到 相同的 root 也就是可以移除的
     * 可以用 rank 提高效率，但想要先練別的就沒有寫
     */
    class Solution {
        private int len;
        private int[] root;

        public int[] findRedundantConnection(int[][] edges) {
            len = edges.length;
            root = new int[len + 1];
            for (int i = 0; i < len + 1; i++) {
                root[i] = i;
            }

            for (int i = 0; i < len; i++) {
                int left = edges[i][0], right = edges[i][1];
                if (isConnected(left, right)) {
                    return edges[i];
                }
                union(left, right);
            }
            return null;
        }

        public boolean isConnected(int left, int right) {
            int leftRoot = find(left);
            int rightRoot = find(right);

            return leftRoot == rightRoot;
        }

        public int find(int num) {
            if (root[num] != num) {
                root[num] = find(root[num]);
            }
            return root[num];
        }

        public void union(int left, int right) {
            int leftRoot = find(left);
            int rightRoot = find(right);

            if (leftRoot != rightRoot) {
                root[rightRoot] = leftRoot;
            }
        }
    }
}
