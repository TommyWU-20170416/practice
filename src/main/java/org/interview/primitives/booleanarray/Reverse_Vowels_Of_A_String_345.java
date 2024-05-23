package org.interview.primitives.booleanarray;

/**
 * 利用 ASCII 索引的數組訪問技巧
 * 實際應用可以參考: https://github.com/TommyWU-0416/coding_interview_question/blob/master/leetcode/blind75/array/Reverse_Vowels_Of_A_String_345.java
 */

public class Reverse_Vowels_Of_A_String_345 {

    public static void main(String[] args) {
        String str = "racecar";
        String vowels = "aeiouAEIOU";
        int count = 0;
        char[] word = str.toCharArray();

        /** 使用 indexOf 尋找 str 有 vowels 的次數 */
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(word[i]) > -1) {
                count++;
            }
        }
        System.out.println("使用 indexOf 尋找 str 有 vowels 的次數: " + count);
        count = 0;

        /** 使用 boolean 尋找 str 有 vowels 的次數 */
        boolean[] isVowels = new boolean['z' + 1];
        isVowels['a'] = true;
        isVowels['e'] = true;
        isVowels['i'] = true;
        isVowels['o'] = true;
        isVowels['u'] = true;
        isVowels['A'] = true;
        isVowels['E'] = true;
        isVowels['I'] = true;
        isVowels['O'] = true;
        isVowels['U'] = true;
        for (int i = 0; i < str.length(); i++) {
            if (isVowels[word[i]]) {
                count++;
            }
        }
        System.out.println("使用 indexOf 尋找 str 有 vowels 的次數: " + count);

        // 兩者差異在於 indexOf 是 O(n)，boolean 是 O(1)
    }

}