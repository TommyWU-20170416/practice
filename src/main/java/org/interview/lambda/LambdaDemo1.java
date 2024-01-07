package org.interview.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class LambdaDemo1 {

    @Test
    public void test1(){
        /**
         * 這邊實現 Comparator<Integer> 的接口
         */
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        /**
         * public TreeSet(Comparator<? super E> comparator)  告訴 TreeSet 要使用 我定義的 Comparator 接口
         */
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    @Test
    public void test1ReplaceLambda(){
        /**
         * 使用 Lambda 改寫
         */
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }
}
