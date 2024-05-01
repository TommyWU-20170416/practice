package org.datastructuresandalgorithms.hiskio.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 練習 Priority queue 使用
 */
public class Priority_Queue {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4, 3, 1, 5, 2};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        while (true) {
            if (pq.size() == 0) break;
            Integer num_min = pq.poll();
            System.out.print(num_min + " ");
        }

        /**
         * custome
         * 在一群人之中排出 要趕快去上廁所的人
         */
        Person[] people = new Person[]{new Person(19, 60), new Person(28, 45), new Person(48, 32), new Person(60, 19), new Person(33, 200)};

        PriorityQueue<Person> pq_people = new PriorityQueue<>(people.length, new MyComparator());
        for (int i = 0; i < people.length; i++) {
            pq_people.add(people[i]);
        }
        System.out.print("\npeepee wait time: ");
        while (true) {
            if (pq_people.size() == 0) break;
            Person p = pq_people.poll();
            System.out.print(p.peepee_wait_time + " ");
        }

        System.out.println();
    }

    /**
     * 定義 Person 可以等待上廁所的時間
     */
    static class Person {
        Integer age;
        Integer peepee_wait_time;

        public Person(Integer age, Integer peepee_wait_time) {
            this.age = age;
            this.peepee_wait_time = peepee_wait_time;
        }
    }

    /**
     * 定義要排序的方式
     */
    static class MyComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.peepee_wait_time.compareTo(p2.peepee_wait_time); // low > high
        }
    }
}
