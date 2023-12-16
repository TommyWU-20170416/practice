package org.interview.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {

    private String name;
    private int age;
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address.getCity(), this.address.getStreet());
        return cloned;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address {

    private String city;
    private String street;

}