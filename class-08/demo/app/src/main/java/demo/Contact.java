package demo;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    String firstName;
    String lastName;
    int age;
    Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return age == contact.age && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public class Address {
        String streetAddress;
        String city;
        String state;
        int postalCode;

        @Override
        public String toString() {
            return "Address{" +
                    "streetAddress='" + streetAddress + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", postalCode=" + postalCode +
                    '}';
        }
    }

    public class PhoneNumber {
        String type;
        String number;

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "type='" + type + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}