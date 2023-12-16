package org.interview.shallowcopy;

/**
 * Object clone 實作淺拷貝
 * Address 作為內部類會指向相同位置，將會一起修改
 * Person 的 age 是數據類型，因此只複製value，不會一起修改
 * Person 的 name 由於是 String具有 immutable 特性，當有不一樣的內容後會新創一個出來
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("tayouan", "onetwo");
        Person person1 = new Person("amber", 23, address);
        Person person2 = (Person) person1.clone();

        System.out.println("==============Original============");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println("==============After change============");
        person2.setAge(24);
        person2.setName("tony");
        person2.getAddress().setCity("taipei");
        System.out.println(person1);
        System.out.println(person2);
    }
}