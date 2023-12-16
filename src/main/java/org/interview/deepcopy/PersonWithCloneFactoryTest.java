package org.interview.deepcopy;

/**
 * 這邊測試的是 使用 newInstance 這類的靜態工廠方法達到深拷貝
 */
public class PersonWithCloneFactoryTest {
    public static void main(String[] args) {
        AddressWithCloneFactory address = new AddressWithCloneFactory("LA", "la");
        PersonWithCloneFactory original = new PersonWithCloneFactory("LA Boy", 23, address);
        // 使用 構造器
        PersonWithCloneFactory copyUsingConstructor = new PersonWithCloneFactory(original);
        // 使用 靜態工廠方法
        PersonWithCloneFactory copyUsingFactory = PersonWithCloneFactory.newInstance(copyUsingConstructor);

        System.out.println("==============Original============");
        System.out.println(original);
        System.out.println(copyUsingConstructor);
        System.out.println(copyUsingFactory);
        System.out.println("==============After change============");
        copyUsingConstructor.setAge(24);
        copyUsingConstructor.setName("SF Girl");
        copyUsingConstructor.getAddress().setCity("SF");
        System.out.println(original);
        System.out.println(copyUsingConstructor);
        System.out.println(copyUsingFactory);
    }

}
