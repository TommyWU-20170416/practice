package org.datastructuresandalgorithms.hiskio.stack;

/**
 * https://hiskio.com/courses/465/lectures/25746
 * <p>
 * 使用 list 打造一個 stack 功能
 * <p>
 * list 會自動增長，所以不用 expand_size()
 * <p>
 * Q: 想想看，node.next 的運作方式
 */
public class Stack_List {

    static class Node {
        Node next;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    Integer[] array;
    Node node_top; // 這個要做什麼用的

    public Stack_List(Integer[] array) {
        this.array = array;
    }

    public void build_stack() {
        for (int i = 0; i < this.array.length; i++) {
            push(array[i]);
        }
    }

    /**
     * 因為 stack 由上往下添加，所以 node_new 的下一個就是原本的 node_top
     *
     * @param value
     */
    private void push(Integer value) {
        if (node_top == null) {
            node_top = new Node(value);
        } else {
            Node node_new = new Node(value);
            node_new.next = node_top;
            node_top = node_new;
        }
    }

    public Integer pop() {
        if (node_top == null) return null;

        Node node = node_top;
        node_top = node_top.next;
        return node.value;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Stack_List stack_array = new Stack_List(nums);
        stack_array.build_stack();

        // full - extend the storage size
        stack_array.push(6);

        Integer num = stack_array.pop();
        num = stack_array.pop();
        num = stack_array.pop();
        num = stack_array.pop();
        num = stack_array.pop();
        num = stack_array.pop();

//         empty
        num = stack_array.pop();

        System.out.println();

    }

}
