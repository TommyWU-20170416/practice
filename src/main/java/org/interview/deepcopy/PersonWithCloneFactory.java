package org.interview.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonWithCloneFactory {

    private String name;
    private int age;
    private AddressWithCloneFactory address;

    /** 給 Person1 使用的 */
    public PersonWithCloneFactory(PersonWithCloneFactory original) {
        this.name = original.name;
        this.address = new AddressWithCloneFactory(original.address.getCity(), original.address.getStreet());
        this.age = original.age;
    }

    /** 給 Person2 使用的 */
    static PersonWithCloneFactory newInstance(PersonWithCloneFactory original) {
        return new PersonWithCloneFactory(original.name, original.age, new AddressWithCloneFactory(original.address.getCity(), original.address.getStreet()));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AddressWithCloneFactory {

    private String city;
    private String street;

}