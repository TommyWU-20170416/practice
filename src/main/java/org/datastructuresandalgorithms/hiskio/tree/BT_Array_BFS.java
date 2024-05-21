package org.datastructuresandalgorithms.hiskio.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用 array 練習 binary tree
 */
public class BT_Array_BFS {
    private Integer[] nums;

    public BT_Array_BFS(Integer[] nums) {
        this.nums = nums;
    }

    /**
     * 實做 BFS，借助 queue 先進先出的概念
     */
    public void traverse_levelorder_bfs() {
        if (this.nums == null || this.nums.length == 0) return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (true) {
            if (queue.size() == 0) break;

            Integer i = queue.poll();
            if (i >= this.nums.length) continue; // 這是因為他也會去計算 3 的左右節點，算出後會是 19, 20 但其實已經超過 14 總長度
            if (this.nums[i] == null) continue;

            if (nums[i] != null) System.out.print(this.nums[i] + " ");
            queue.add((i + 1) * 2 - 1);
            queue.add((i + 1) * 2);

        }
    }
}
