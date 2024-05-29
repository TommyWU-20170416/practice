package org.datastructuresandalgorithms.hiskio.tree;

/**
 * https://hiskio.com/courses/434/lectures/22759
 * <p>
 * 使用二元搜尋法找資料
 */
public class BST_SortedArray {
    private Integer[] nums;

    public BST_SortedArray(Integer[] nums) {
        this.nums = nums;
    }

    public Integer search(int val) {
        int i_start = 0;
        int i_end = this.nums.length - 1;
        int i_root = (i_end + i_start) / 2; // mid by left
        if (this.nums[i_root] == null) return null;

        return search(val, i_start, i_end);
    }

    private Integer search(int val, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int i_mid = (i_end + i_start) / 2;

        if (val == this.nums[i_mid]) {
            return this.nums[i_mid];
        } else if (val < this.nums[i_mid]) {
            return search(val, i_start, i_mid - 1);
        } else if (val > this.nums[i_mid]) {
            return search(val, i_mid + 1, i_end);
        }

        return null;
    }

    public Integer search_leftmost(int val) {
        int i_start = 0;
        int i_end = this.nums.length - 1;
        int i_root = (i_end + i_start) / 2; // mid by left
        if (this.nums[i_root] == null) return null;

        return search_leftmost(val, i_start, i_end);
    }

    private Integer search_leftmost(int val, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int i_mid = (i_end + i_start) / 2;

        if (val == this.nums[i_mid]) {
            Integer result = this.nums[i_mid];
            Integer result_left = search_leftmost(val, i_start, i_mid - 1);
            if (result_left != null) {
                result = result_left;
                System.out.println("found more left result");
            }

            return result;
        } else if (val < this.nums[i_mid]) {
            return search_leftmost(val, i_start, i_mid - 1);
        } else if (val > this.nums[i_mid]) {
            return search_leftmost(val, i_mid + 1, i_end);
        }

        return null;
    }

    public Integer search_rightmost(int val) {
        int i_start = 0;
        int i_end = this.nums.length - 1;
        int i_root = (i_end + i_start) / 2; // mid by left
        if (this.nums[i_root] == null) return null;

        return search_rightmost(val, i_start, i_end);
    }

    private Integer search_rightmost(int val, int i_start, int i_end) {
        if (i_start > i_end) return null;
        int i_mid = (i_end + i_start) / 2;

        if (val == this.nums[i_mid]) {
            Integer result = this.nums[i_mid];
            Integer result_left = search_rightmost(val, i_mid + 1, i_end);
            if (result_left != null) {
                result = result_left;
                System.out.println("found more right result");
            }

            return result;
        } else if (val < this.nums[i_mid]) {
            return search_rightmost(val, i_start, i_mid - 1);
        } else if (val > this.nums[i_mid]) {
            return search_rightmost(val, i_mid + 1, i_end);
        }

        return null;
    }
}
