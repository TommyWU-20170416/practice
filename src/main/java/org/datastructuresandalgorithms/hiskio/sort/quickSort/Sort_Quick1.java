package org.datastructuresandalgorithms.hiskio.sort.quickSort;

/**
 * 實際操作，以 [3, 1, 5, 2, 4] 為例子
 * <h2>第一個 pivot 為 3</h2>
 * <ol>
 *     <li>i = left, j = right，left & right 要當作之後的邊界</li>
 *     <li>i = 0, j = 4，從左邊去找 < 3 的，從右邊去找 > 3</li>
 *     <li>這時候會找到 i = 2, j = 3 的地方，代表說這個位置的左邊 比 3 小，右邊比 3 大</li>
 *     <li>因為 i 跟 j 還沒有碰到，代表說這邊做完交換後才會有 pivot 的位置</li>
 *     <li>所以交換 2 和 5，得到 [3, 1, 2, 5, 4] i = 2, j = 3</li>
 *     <li>繼續檢查 pivot 適合的位置，接著就會找到 i = 2, j = 2</li>
 *     <li>交換 3 和 2，得到 [2, 1, 3, 5, 4]</li>
 * </ol>
 * <h3>得到 [2, 1, 3, 5, 4]</h3>
 * <p>
 * <p>
 * 交換之後 pivot 就是對的位置，接下來就要繼續看兩側，分別是 [2, 1] 和 [5, 4]
 * <h2>左側 [2, 1]</h2>
 * <ol>
 *    <li>i = 0, j = 1</li>
 *    <li>這時候會找到 i = 1, j = 1 的地方，代表說這個位置的左邊 比 2 小，右邊比 2 大，所以跟 pivot 交換</li>
 * </ol>
 * <h3>得到 [1, 2]</h3>
 * [1, 2] 會繼續往下拆，最後再回傳
 * <p>
 * <p>
 * <h2>右側 [5, 4]</h2>
 * <ol>
 *     <li>i = 3, j = 4</li>
 *     <li>這時候會找到 i = 4, j = 4 的地方，代表說這個位置的左邊 比 5 小，右邊比 5 大，所以跟 pivot 交換</li>
 * </ol>
 * <h3>得到 [4, 5]</h3>
 * <p>
 * <pre>
 * [3, 1, 5, 2, 4]  => [2, 1, 3, 5, 4] 確認 3 位置
 * [2, 1]           => [1, 2         ] 確認 2 位置
 * [5, 4]           => [         4, 5] 確認 5 位置
 * [1]              => [1            ] 確認 1 位置
 * [4]              => [         4   ] 確認 4 位置
 * </pre>
 * 依照這樣的方式，由於每次都是將近二分，所以是 O(logN)輪，每一輪都要檢查 N 個，所以是 O(N logN)
 * 但如果每次都挑到最大或最小，就會單一的拆開來，就會是 O(N^2)
 */
public class Sort_Quick1 {

    // 執行幾次
    private static int checkTimes = 0;

    public static void quick_sort(int[] nums) {
        quick_sort(nums, 0, nums.length - 1);
    }

    private static void quick_sort(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivot = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            checkTimes++;
            while (i < j && nums[j] >= pivot) {
                checkTimes++;
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                checkTimes++;
                i++;
            }

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;

        quick_sort(nums, left, i - 1);
        quick_sort(nums, i + 1, right);
    }

    public static void main(String[] args) {
//        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
        int[] nums = {3, 1, 5, 2, 4}; // 測試部分已排序
        quick_sort(nums);

        System.out.println("總共檢查 " + checkTimes + " 次");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
