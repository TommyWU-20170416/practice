package org.datastructuresandalgorithms.hiskio.commonlyused;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://hiskio.com/courses/465/lectures/25741
 * <p>
 * 找出 start > target 最短路徑
 * <p>
 * Q: 為什麼不會發生後面的步數超越前面的
 * A: 不是不可能，這就是貪婪法可能不是最優解的原因
 * 他只會抓取當下最小成本的解去做組合，所以是有可能為次優解
 */
public class Greedy {
    Integer[][] maze; // 準備要走的迷宮
    PriorityQueue<Node> pq; // 存放 node 內經過的 成本，並且有小排到大
    Integer[][] maze_best; // 存放最佳解的

    // 設計 node
    static class Node {
        Integer row;
        Integer col;
        Integer cost;

        public Node(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }

    // 定義 queue 的比較方式
    static class MyComp implements Comparator<Node> {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.cost.compareTo(node2.cost); // low > high
        }
    }

    // constructor
    public Greedy(Integer[][] maze) {
        this.maze = maze;
        this.pq = new PriorityQueue<>(20, new MyComp());
        this.maze_best = new Integer[maze.length][maze[0].length];
    }

    // 計算路徑的地方
    public Integer go_maze(int row_start, int col_start, int row_end, int col_end) {
        Node start = new Node(row_start, col_start);
        start.cost = this.maze[row_start][col_start];
        Node target = new Node(row_end, col_end);

        return go_maze(start, target);
    }

    // 整理 start 跟 target，方便後面使用
    private Integer go_maze(Node start, Node target) {
        pq.add(start);

        // init
        while (true) {
            if (pq.size() == 0) break;
            Node now = pq.poll();
            System.out.println("-- 準備做 [" + now.row + "][" + now.col + "]=" + now.cost);

            // 已經放過的就不用再放
            if (maze_best[now.row][now.col] != null) continue;

            // 這邊 poll 後的解為當前最好的解，因為已經使用排序去比較過當前的大小
            // 注意: 這邊可能會覺得很怪，因為會想成說他是去比較每一個到 [][] 的路徑距離，再放到 maze_best，但其實他只是針對當下最短路徑的去提供
            // 例如: 現在 pq 內有[1][2] = 5, [2][2] = 1; 他就會優先做 [2][2]，因為他是當前最小的距離
            this.maze_best[now.row][now.col] = now.cost;

            // node explore，檢查上下界線是不是有超過範圍
            // 如果沒有就把原本的數值 + 上面的數值
            // 上
            if (now.row - 1 >= 0) {
                Node up = new Node(now.row - 1, now.col);
                System.out.println("改變前 [" + up.row + "][" + up.col + "]=" + this.maze[up.row][up.col]);
                up.cost = now.cost + this.maze[up.row][up.col];
                System.out.println("改變後 [" + up.row + "][" + up.col + "]=" + up.cost);
                pq.add(up);
            }
            // 下
            if (now.row + 1 < maze.length) {
                Node down = new Node(now.row + 1, now.col);
                System.out.println("改變前 [" + down.row + "][" + down.col + "]=" + this.maze[down.row][down.col]);
                down.cost = now.cost + this.maze[down.row][down.col];
                System.out.println("改變後 [" + down.row + "][" + down.col + "]=" + down.cost);
                pq.add(down);
            }
            // 左
            if (now.col - 1 >= 0) {
                Node left = new Node(now.row, now.col - 1);
                System.out.println("改變前 [" + left.row + "][" + left.col + "]=" + this.maze[left.row][left.col]);
                left.cost = now.cost + this.maze[left.row][left.col];
                System.out.println("改變後 [" + left.row + "][" + left.col + "]=" + left.cost);
                pq.add(left);
            }
            // 右
            if (now.col + 1 < maze[0].length) {
                Node right = new Node(now.row, now.col + 1);
                System.out.println("改變前 [" + right.row + "][" + right.col + "]=" + this.maze[right.row][right.col]);
                right.cost = now.cost + this.maze[right.row][right.col];
                System.out.println("改變後 [" + right.row + "][" + right.col + "]=" + right.cost);
                pq.add(right);
            }
        }

        return this.maze_best[target.row][target.col];
    }

    public static void main(String[] args) {

//        Integer[][] maze = new Integer[][]{{1, 3, 1, 2, 9}, {7, 3, 4, 9, 9}, {1, 7, 5, 5, 3}, {2, 3, 4, 2, 5},};
        Integer[][] maze = new Integer[][]{{1, 4, 4}, {2, 2, 1}};

        Greedy gmc = new Greedy(maze);

        int row_start = 0;
        int col_start = 0;
        int row_target = 1;
        int col_target = 2;

        int cost_min = gmc.go_maze(row_start, col_start, row_target, col_target);

        System.out.println("從[" + row_start + "][" + col_start + "]到[" + row_target + "][" + col_target + "]需要 " + cost_min + "步");
    }

}
