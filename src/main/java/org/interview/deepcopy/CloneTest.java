package org.interview.deepcopy;

/**
 * Object clone 實作深拷貝 = 淺拷貝 + 賦值給 address
 * 跟淺拷貝的數據相比，僅 Address 作為內部類會新創一個出來，不會一起修改
 * 其餘皆一樣
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