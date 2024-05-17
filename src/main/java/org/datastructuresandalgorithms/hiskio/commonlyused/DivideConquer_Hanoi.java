package org.datastructuresandalgorithms.hiskio.commonlyused;

import java.util.Stack;

public class DivideConquer_Hanoi {
    static Stack<String> pillar_A = new Stack<>();
    static Stack<String> pillar_B = new Stack<>();
    static Stack<String> pillar_C = new Stack<>();

    public static void main(String[] args) {
        /** initialization **/
//        pillar_A.add(5);
//        pillar_A.add("D");
        pillar_A.add("C");
        pillar_A.add("B");
        pillar_A.add("A");

        int layer = pillar_A.size();

        /** Divide & Conquer **/
        hanoi(layer, pillar_A, pillar_B, pillar_C);

        System.out.println();
    }

    private static void hanoi(int layer, Stack<String> pillar_from, Stack<String> pillar_mid, Stack<String> pillar_to) {
        if (layer == 0) return;
        /** base case : when layer == 1, it's our base case **/

        /**
         * step01: move the above plate to the pillar_mid, to clear the room for the plate below
         * 這裡還有一個重要的，當外部呼叫的時候 layer = 2，跟 layer = 3 會得到不一樣的操作順序
         *      h()= hanoi(), l = layout, f = from, m = mid, t = to
         * layer = 2: h(2, f, m ,t) -> h(1, f, t, m)
         * layer = 3: h(3, f, m ,t) -> h(2, f, t, m) -> h(1, f, m ,t)
         *
         * 這樣看還沒感覺，直接看印出的內容
         * layer = 2: 第一個 A 會移到 pillar_B:
         *      pillar_A:A B   	pillar_B:  		pillar_C:
         *      pillar_A:B   	pillar_B:A   	pillar_C:
         * layer = 3: 第一個 A 會移到 pillar_C:
         *      pillar_A:A B C	pillar_B:  		pillar_C:
         *      pillar_A:B C	pillar_B:  		pillar_C:A
         **/
        hanoi(layer - 1, pillar_from, pillar_to, pillar_mid);

        /**
         * step02: main target 把 from 移到 to 這邊是相對概念
         * 第一次的 hanoi 的 from = from 但是 to = mid，等於第一次是移到 暫時的地方
         * 第二次的 hanoi（從 hanoi(layer - 1, pillar_mid, pillar_from, pillar_to);） 來的
         *                 from = mid  但是 to = to ，等於把暫時的移去 to
         * 這邊滿巧妙的，用參數換位置的方式去做切換，需要拿紙筆走一下 function 的內容才會清楚
         */
        String plate = pillar_from.pop();
        pillar_to.push(plate);
        print();

        /**
         * step03: move the original above plate back
         */
        hanoi(layer - 1, pillar_mid, pillar_from, pillar_to);

    }

    private static void print() {

        System.out.print("pillar_A:");
        printStack(pillar_A);

        System.out.print("  pillar_B:");
        printStack(pillar_B);

        System.out.print("  pillar_C:");
        printStack(pillar_C);

        System.out.println();
    }

    private static void printStack(Stack<String> stringStack) {
        StringBuilder str = new StringBuilder();
        if (stringStack == null || stringStack.size() == 0) return;
        Stack<String> tmp = new Stack<>();
        int size = stringStack.size();

        for (int i = 0; i < size; i++) {
            StringBuilder strNow = new StringBuilder();
            tmp.push(stringStack.pop());
            str.append(tmp.peek() + " ");

            System.out.print(tmp.peek() + " ");
        }
        for (int i = 0; i < size; i++) {
            stringStack.push(tmp.pop());
        }
    }
}
// 三層的換法
//pillar_A:A B C  pillar_B:  		pillar_C:
//pillar_A:B C   	pillar_B:  		pillar_C:A
//pillar_A:C   	pillar_B:B   	pillar_C:A
//pillar_A:C   	pillar_B:A B   	pillar_C:
//pillar_A:  		pillar_B:A B   	pillar_C:C
//pillar_A:A   	pillar_B:B   	pillar_C:C
//pillar_A:A   	pillar_B:  		pillar_C:B C
//pillar_A:  		pillar_B:  		pillar_C:A B C