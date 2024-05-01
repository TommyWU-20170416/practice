package org.datastructuresandalgorithms.hiskio.stack;

/**
 * https://hiskio.com/courses/465/lectures/25745
 * <p>
 * 使用 array 打造一個 stack 功能
 */
public class Stack_Array {

    /**
     * 收集原始資料
     */
    Integer[] array;
    /**
     * 存放 stack 的地方
     */
    Integer[] stack;
    /**
     * 最上面的值
     */
    Integer i_top = null;

    public Stack_Array(Integer[] array) {
        this.array = array;
    }

    public void build_stack() {
        this.stack = new Integer[array.length];
        for (int i = 0; i < stack.length; i++) {
            push(array[i]);
        }
    }

    private void push(Integer value) {
        /** 檢查大小 */
        if (size() >= stack.length) expand_space();

        if (i_top == null) {
            // 初次建立
            i_top = 0;
        } else {
            i_top++;
        }

        stack[i_top] = value;
    }

    private void expand_space() {
        Integer[] stack_tmp = new Integer[this.stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            stack_tmp[i] = stack[i];
        }
        this.stack = stack_tmp;
    }

    private Integer size() {
        if (i_top == null) return 0;
        // i_top 是 index 位置，所以當抓 size 要 +1
        return i_top + 1;
    }

    public Integer pop() {
        if (size() == 0) return null;

        Integer result = stack[i_top];
        stack[i_top] = null;

        if (i_top == 0) {
            i_top = null;
        } else {
            i_top--;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Stack_Array stack_array = new Stack_Array(nums);
        stack_array.build_stack();

        // full - extend the storage size
        stack_array.push(6);
        // 驗證是否有再次呼叫 expand ，若有則錯誤
        stack_array.push(7);

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
