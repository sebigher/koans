package org.nowhere.chap1;

import java.util.Optional;

public class Optionals {

    public static void main(String ...args){
        Person person = new Person("John");
        Optional<String> string1 = Optional.empty();
        Optional<String> string2 = Optional.of("Mary");

        changePerson(person, string1);
        System.out.println(person);
        changePerson(person, string2);
        System.out.println(person);

        System.out.println("===========");
        System.out.println(getPersonWithUppercaseName(person, string1));
        System.out.println(getPersonWithUppercaseName(person, string2));
    }

    private static void changePerson(Person person,
                                       Optional<String> stringie) {
        stringie.filter(string -> !string.isEmpty())
                .ifPresent(str ->
                    person.setName(str.toUpperCase()));

    }


    private static Person getPersonWithUppercaseName(Person person,
                                     Optional<String> stringie) {

        return stringie.filter(str -> !str.isEmpty())
                .map(nomptyString -> new Person(nomptyString.toLowerCase()))
                .orElse(new Person("No name"));

    }


}
