package org.datastructuresandalgorithms.hiskio.array;

import java.util.List;

/**
 * https://hiskio.com/courses/465/lectures/24223
 * <p>
 * 實作一個 linkedlist 出來
 * <p>
 * 提供以下方法
 * <p>
 * search by value
 * add by value
 * remove by value
 * <p>
 * 注意: 若有異動 start 或是 end 的 node 就要注意要特別去處理
 */
public class List_Impl {

    /**
     * 宣告一個 Class Node
     */
    static class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }

    private Node start;
    private Node end;

    // add val
    public void add(int val) {
        if (start == null) {
            start = new Node(val);
            end = start;
        } else {
            end.next = new Node(val);
            end = end.next;
        }
    }

    // search by val
    public Integer search(int val) {
        if (null == start) return null;

        Node node = start;
        while (true) {
            if (null == node.val) break; // 已經跑到最後一個 node 就會是 null
            if (node.val == val) return val;
            node = node.next;
        }
        return null;
    }

    // remove node
    public void remove(int val) {
        if (null == start) return;

        Node node = start;
        Node preNode = null;
        while (true) {
            if (null == node.val) break; // 已經跑到最後一個 node 就會是 null
            if (node.val == val) {
                if (node == start) {
                    // 檢查找到的 node == start 因為 start 沒有 preNode
                    start = start.next;
                    return;
                } else if (node == end) {
                    // 檢查找到的 node == end 就把 preNode = null; 且要設定 end
                    preNode.next = null;
                    end = preNode;
                    return;
                }
                // val 不在 開頭 也不在 結尾
                preNode.next = node.next; // 當前 Node 之前的 Node 指向 Node 的下一個 Node
                node = null;
                return;
            }
            preNode = node; // 紀錄當前 node 的前一個
            node = node.next;
        }
    }

    public static void main(String[] args) {
        /** initialize **/
        List_Impl mylist = new List_Impl();

        /** add O(1) - start **/
        mylist.add(9);

        /** add O(1) **/
        mylist.add(11);
        mylist.add(2);
        mylist.add(98);
        mylist.add(35);

        /** search O(n) **/
        int val = mylist.search(98);

        /** remove O(n) **/
        mylist.remove(2);
        mylist.remove(9); // remove start
        mylist.remove(35); // remove end

        System.out.println();
    }

}
