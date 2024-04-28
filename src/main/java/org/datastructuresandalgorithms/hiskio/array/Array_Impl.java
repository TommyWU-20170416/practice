package org.datastructuresandalgorithms.hiskio.array;

/**
 * 實作一個 array 出來
 * <p>
 * 提供以下方法
 * <p>
 * new array
 * <p>
 * search by index
 * search by value
 * add by index
 * add by value
 * remove by index
 * remove by value
 */
public class Array_Impl {
    /**
     * 初始化 array，以及初始化 end 位置
     *
     * @param size
     */
    private Integer[] array;
    private Integer i_end;


    public Array_Impl(int size) {
        array = new Integer[size];
        i_end = -1;
    }

    // search by index
    public Integer search_by_index(int index) {
        return array[index];
    }

    // search by value
    public Integer search_by_value(int value) {
        for (int i = 0; i <= i_end; i++) {
            if (array[i] == value) {
                return array[i];
            }
        }
        return null;
    }

    // add by index
    public void add_by_index(int index, int value) {
        if (i_end + 1 == array.length) expand_space();
        if (index > i_end + 1 || index < 0) return;

        for (int i = i_end; i >= index; i--) { // 想想看為什麼是 i >= index
            array[i + 1] = array[i]; // 左邊移到右邊
            array[i] = null; // 清空左邊
        }
        array[index] = value;
        i_end++;
    }

    // add by value
    public void add_by_value(int value) {
        add_by_index(i_end + 1, value);
    }

    // expand_space
    private void expand_space() {
        Integer[] array_expand = new Integer[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            array_expand[i] = array[i];
        }
        array = array_expand;
    }

    // remove by index
    public void remove_by_index(int index) {
        array[index] = null;

        for (int i = index + 1; i < i_end; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }
        i_end--;
    }

    // remove by value
    public void remove_by_value(int value) {
        for (int i = 0; i < i_end; i++) {
            if(array[i] == value){
                remove_by_index(i);
            }
        }
    }

    public static void main(String[] args) {
        /** initialize **/
        Array_Impl myarray = new Array_Impl(5);

        /** add O(1) **/
        myarray.add_by_value(9);
        myarray.add_by_value(11);
        myarray.add_by_value(2);
        myarray.add_by_value(98);
        myarray.add_by_value(35);

        /** add by value O(1) + expand O(n) **/
        myarray.add_by_value(44);

        /** add by index O(n) **/
        int i_add = 1;
        myarray.add_by_index(i_add, 50);

        /** search by value O(n) **/
        Integer val001 = myarray.search_by_value(2882);

        /** search by index O(1) **/
        Integer val002 = myarray.search_by_index(4);

        /** remove by value O(n) **/
        myarray.remove_by_value(2);

        /** remove by index O(n) **/
        int i_remove = 3;
        myarray.remove_by_index(i_remove);

        System.out.println();
    }
}
