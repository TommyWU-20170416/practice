package org.datastructuresandalgorithms.hiskio.tree;

/**
 * https://hiskio.com/courses/434/lectures/22736
 */

/**
 * 使用 list 製作 binary search tree 的 treeSort 且有重複
 * 因此只要修改 private BST_Node add(BST_Node node, int val) 的時候重複新增的邏輯
 */
public class BST_TreeSort_List {

    private int[] nums;
    private BST_Node root;

    public static class BST_Node {
        public BST_Node left;
        public BST_Node right;
        public int val;
        public String owner;

        public BST_Node() {
        }

        public BST_Node(int val, String owner) {
            this.val = val;
            this.owner = owner;
        }

        public BST_Node(int val) {
            this.val = val;
        }
    }

    public BST_TreeSort_List(int[] nums) {
        this.nums = nums;
    }

    /**
     * insert
     */
    public void buildtree() {
        for (int i = 0; i < this.nums.length; i++) {
            add(this.nums[i]);
        }
    }

    private void add(int val) {
        BST_Node root_after_add = add(this.root, val);

        // 執行完 add(this.root, val) 回傳一個 node，因為 root 初始為 null，且 root_after_add 是一個有 val 的 node 所以會不一樣
        // 也就代表是第一次新增的
        // 如果是第二次新增會發生什麼事情
        // 什麼都不會發生，因為本來 add 方法就是傳 this.root，接下來都是直接更新 root，所以回傳的內容就會是 root
        // 只有初次回傳不一樣而已
        if (this.root != root_after_add)
            this.root = root_after_add;
    }

    private BST_Node add(BST_Node node, int val) {
        if (node == null) return new BST_Node(val);

        if (val == node.val) {
            // 兩種情境
            // 左邊 null
            if (node.left == null) {
                node.left = new BST_Node(val);
            }
            // 左邊 有值
            else if (node.left != null) {
                BST_Node node_new = new BST_Node(val);
                node_new.left = node.left;
                node.left = node_new;
            }
        }
        // 如果小於 node 往左走
        else if (val < node.val) {
            BST_Node left_node = add(node.left, val);
            // 搭配 if (node == null) return new BST_Node(val); 使用
            if (node.left != left_node)
                node.left = left_node;
        }
        // 如果大於 node 往右走
        else if (val > node.val) {
            BST_Node right_node = add(node.right, val);
            // 搭配 if (node == null) return new BST_Node(val); 使用
            // add(node.right, val) 會一路往下跑，根據比大小後決定
            // 然後當今天已經跑到 node == null 代表已經是最後一個，所以要 return new BST_Node(val)
            // return 後 要把她接續原本的值做關聯
            if (node.right != right_node)
                node.right = right_node;
        }
        return node;
    }

    /**
     * delete
     */
    public void delete(int val) {
        if (this.root == null) return;
        BST_Node root_after_delete = delete(this.root, val);
        if (root_after_delete != this.root) {
            this.root = root_after_delete;
        }
    }

    private BST_Node delete(BST_Node node, int val) {
        if (node == null) return null; // 找到最後沒有找到要刪除的值

        if (val == node.val) {
            // main logic
            // X    X
            if (node.left == null && node.right == null) {
                return null;
            }
            // left X
            if (node.left != null && node.right == null) {
                return node.left;
            }
            // X    right
            if (node.left == null && node.right != null) {
                return node.right;
            }
            // left right
            if (node.left != null && node.right != null) {
                // find the right min
                BST_Node node_right_min = getMin(node.right);
                // swap the delete traget and node.right
                swap_node_val(node, node_right_min);
                // 2nd delete
                BST_Node node_child = delete(node.right, val);
                if (node_child != node.right) {
                    node.right = node_child;
                }
            }
        }
        if (val < node.val) {
            BST_Node delete_left = delete(node.left, val);
            if (delete_left != node.left) node.left = delete_left;
        } else if (val > node.val) {
            BST_Node delete_right = delete(node.right, val);
            if (delete_right != node.right) node.right = delete_right;
        }

        return node;
    }

    private BST_Node getMin(BST_Node node) {
        while (true) {
            if (node.left == null) break;
            node = node.left;
        }
        return node;
    }

    private void swap_node_val(BST_Node left, BST_Node right) {
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
    }

    /**
     * search
     */
    public BST_Node search(int val) {
        if (this.root == null) return null;
        return search(this.root, val);
    }

    private BST_Node search(BST_Node node, int val) {
        if (node == null) return null;

        BST_Node result = null;
        if (val == node.val) {
            result = node;
        } else if (val < node.val) {
            result = search(node.left, val);
        } else if (val > node.val) {
            result = search(node.right, val);
        }

        return result;
    }

    /**
     * preorder, inorder, postorder
     */
    public void traverse_inorder_dfsleft() {
        if (this.root == null) return;
        this.traverse_inorder_dfsleft(this.root);
    }

    private void traverse_inorder_dfsleft(BST_Node node) {
        if (node == null) return;
        traverse_inorder_dfsleft(node.left);
        System.out.print(node.val + " ");
        traverse_inorder_dfsleft(node.right);
    }

    public void traverse_inorder_dfsright() {
        if (this.root == null) return;
        this.traverse_inorder_dfsright(this.root);
    }

    private void traverse_inorder_dfsright(BST_Node node) {
        if (node == null) return;

        traverse_inorder_dfsright(node.right);

        System.out.print(node.val + " ");

        traverse_inorder_dfsright(node.left);
    }

    /** tree sort (DFS left) **/
    public static void tree_sort_ascending(int[] nums) {
        BST_TreeSort_List bst = new BST_TreeSort_List(nums);
        bst.buildtree();
        bst.traverse_inorder_dfsleft();
    }

    /** tree sort (DFS right) **/
    public static void tree_sort_descending(int[] nums) {
        BST_TreeSort_List bst = new BST_TreeSort_List(nums);
        bst.buildtree();
        bst.traverse_inorder_dfsright();
    }
}

