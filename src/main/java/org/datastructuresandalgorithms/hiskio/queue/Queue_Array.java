package org.datastructuresandalgorithms.hiskio.queue;

/**
 * https://hiskio.com/courses/465/lectures/25742
 * <p>
 * 使用 array 打造一個 環狀queue 功能
 * <p>
 * Q; 為什麼 poll 內的 size() == 1 判斷，而不是 size() == 0
 * Q: expand_space 想想看為什麼要這樣寫
 */
public class Queue_Array {
    Integer i_start = null;
    Integer i_end = null;
    Integer[] array;
    Integer[] queue;

    public Queue_Array(Integer[] nums) {
        this.array = nums;
    }

    public void build_queue() {
        this.queue = new Integer[array.length];
        for (int i = 0; i < queue.length; i++) {
            offer(array[i]);
        }
    }

    private void offer(Integer value) {
        if (size() >= queue.length) expand_space();

        if (size() == 0) {
            i_start = 0;
            i_end = 0;
            queue[i_end] = value;
        } else {
            i_end++;
            i_end %= queue.length; // 因為是環形所以可能會超過
            queue[i_end] = value;
        }
    }

    private Integer size() {
        if (null == i_start && null == i_end) {
            // 都是 null 表示還沒有一個數值放入過
            return 0;
        } else if (i_end >= i_start) {
            // 還沒有達到新的一環
            // 要加一是因為這兩個是 index 相減
            return i_end - i_start + 1;
        } else if (i_end < i_start) {
            // 已經達到新的一環
            return queue.length - i_start + i_end + 1;
        }
        return null;
    }

    private void expand_space() {
        Integer[] queue_tmp = new Integer[queue.length * 2];
        /**
         * 這樣寫繪有一個問題
         * 當今天是環形 queue，且 end 已經繞一圈 < start
         * 假設今天的 value 0-4 都被 poll，從 index = 5 繼續排續繞一圈回到 index = 4
         * index: 0 1 2 3 4 5 6 7 8 9
         * value: 5 6 7 8 9 0 1 2 3 4
         *
         * 這時候要把她們放到新的 queue ，且順序要依照
         */
//        for (int i = 0; i < queue.length; i++) {
//            queue_tmp[i] = queue[i];
//        }
//        this.queue = queue_tmp;

        /**
         * 呼叫另一種方式去實作 poll
         */
        int i = 0; // 新 queue 起始位置
        while (true) {
            if (size() == 0) break;
            Integer value = poll(); // 會從 i_start 開始把值繳回
            queue_tmp[i] = value;
            i++;
        }
        i_start = 0;
        i_end = i - 1; // 因為 while 是放完值就加，所以放到最後一個值後也會加 1，因此要減去
        this.queue = queue_tmp;
    }

    public Integer poll() {
        if (size() == 0) return null;

        Integer reuslt = queue[i_start];
        queue[i_start] = null;

        // 這邊的 size 是用 end - start ，不是直接計算 queue.length
        // 若按照 queue.lenth 去算會得到長度 expand 後的
        // 若使用 end - start 去算，在剩下1 的時候代表實際上已經剩下一個，而且已經被上面取完，所以就要把 start end 改成 null
        if (size() == 1) {
            // 如果移除後剩下 0 就要回 Null
//            queue = null; 不用寫是因為，上面的 queue[i_start] = null; 如果一路做下去就會把 queue 變成 Null 到時候就回收了
            i_start = null;
            i_end = null;
        } else {
            i_start++;
            i_start %= queue.length;
        }

        return reuslt;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Queue_Array queue_array = new Queue_Array(nums);
        queue_array.build_queue();

        // full - extend the storage size
        queue_array.offer(6);
        queue_array.offer(7);

        Integer val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();

        // empty
        val = queue_array.poll();
//
//        // circular queue - i_end test
        queue_array.offer(11);
        queue_array.offer(12);
        queue_array.offer(13);
        queue_array.offer(14);
        queue_array.offer(15);
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
        val = queue_array.poll();
//
        for (int i = 0; i < 80; i++) {
            queue_array.offer(30 + i);
        }

        System.out.println();
    }
}
