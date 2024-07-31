import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountTwoArraySameElement {
    public static void main(String[] args) {
        int[] a = {13, 27, 35, 40, 49, 55, 59};
        int[] b = {17, 35, 39, 40, 55, 58, 60};
        CountTwoArraySameElement p = new CountTwoArraySameElement(); // Output: 3
        int res = p.countTwoArraySameElement(a, b);
        System.out.println("result:" + res);
    }

    /**
     * time complexity: O(n * n)
     * space complexity: O(1)
     *
     * 使用 hashset 減少 time
     */
//    private int countTwoArraySameElement(int[] a, int[] b) {
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                if (a[i] == b[j]) count++;
//            }
//        }
//        return count;
//    }

    /**
     * time complexity: O(2n) = O(n)
     * space complexity: O(n)
     * <p>
     * 不用 hashset 節省空間
     */
    private int countTwoArraySameElement(int[] a, int[] b) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (set.contains(b[i])) count++;
        }
        return count;
    }
    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
//    private int countTwoArraySameElement(int[] a, int[] b) {
//        int count = 0;
//        for (int i = 0, j = 0; i < a.length && j < b.length; ) {
//            int aVal = a[i];
//            int bVal = b[j];
//            if (aVal > bVal) {
//                j++;
//            } else if (aVal < bVal) {
//                i++;
//            } else {
//                count++;
//                i++;
//                j++;
//            }
//        }
//        return count;
//    }
}
