package org.datastructuresandalgorithms.hiskio.queue;

/**
 * https://hiskio.com/courses/465/lectures/25743
 * <p>
 * 使用 list 打造一個 環狀queue 功能
 * <p>
 */
public class Queue_List {
    static class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }

    Integer[] nums;
    Node node_front = null;
    Node node_end = null;

    public Queue_List(Integer[] nums) {
        this.nums = nums;
    }

    public void build_queue() {
        for (int i = 0; i < nums.length; i++) {
            offer(nums[i]);
        }
    }

    private void offer(Integer value) {
        if (node_front == null) {
            node_front = new Node(value);
            node_end = node_front;
        } else {
            node_end.next = new Node(value);
            node_end = node_end.next;
        }
    }

    public Integer poll() {
        if (node_front == null) return null;

        Integer result = node_front.val;
        node_front = node_front.next;
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Queue_List queue_list = new Queue_List(nums);
        queue_list.build_queue();

        // full - extend the storage size
        queue_list.offer(6);
        queue_list.offer(7);

        Integer num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();
        num = queue_list.poll();

        // empty
        num = queue_list.poll();

        for (int i = 0; i < 80; i++) {
            queue_list.offer(30 + i);
        }

        System.out.println();
    }
}
