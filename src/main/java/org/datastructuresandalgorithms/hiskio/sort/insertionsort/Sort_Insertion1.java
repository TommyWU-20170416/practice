package org.datastructuresandalgorithms.hiskio.sort.insertionsort;

/**
 * https://hiskio.com/courses/465/lectures/23095
 * <p>
 * 實作 Insertion Sort
 * <p>
 * 只要左邊比右邊大的就交換，如果找不到就可以終止這一 round，減少檢查次數
 * 整理的過程會像是撲克牌，你看到 K 會放到最後，看到 Q 會把它放到 K 之前，也就是找到比自己小的就插入
 * <p>
 * Q: 想想這樣做有沒有可再優化的地方
 */
public class Sort_Insertion1 {
    public static void insertion_sort(int[] nums) {
        // 執行幾次
        int checkTimes = 0;

        // 總共要跑的次數
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            // 將 key 插入到已排序的序列中，key 是要插入的元素
            // 如果已排序的序列中的元素比 key 大，就將元素往右移動
            // 直到找到比 key 小的元素，將 key 插入到該元素的右邊
            checkTimes++;
            while (j >= 0 && nums[j] > key) {
                checkTimes++;
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }

        System.out.println("總共檢查 " + checkTimes + " 次");
    }

    public static void main(String[] args) {
//        int[] nums = {5, 4, 3, 2, 1}; // 測試完全相反
        int[] nums = {1,2, 3, 4, 5}; // 測試部分已排序
        insertion_sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
