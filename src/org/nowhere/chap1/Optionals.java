package org.nowhere.chap1;

import java.util.*;
import java.util.stream.Collectors;

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


        //let's suppose we want something like
        // string not null -> make new Person with that string as the name
        //basically, create the Person only when...

        System.out.println("======== =========");

        //list of persons
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("Bee"));
        personList.add(new Person("Muriel"));


        personList.add(new Person("cucu"));
        //list of possible names
        List<String> names = Arrays.asList(null, null, null, null, "leo", null,  "margot");


        String newName = names.get(new Random()
                .nextInt(names.size()));

        System.out.println("New name: " + newName);

        System.out.println("before person list: " + personList);

        Optional.ofNullable(newName)
                //.stream()
                .map(String::toUpperCase)
                .map(ss -> personList.add(new Person(ss)));



        System.out.println("after person list: " + personList);


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
