package org.nowhere.abc.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic4_ConstructorReferenceDemo {

  public static void main(String ...args){
    //we have a list of names
    //we want to build a list of Person objects
    //with those names

    String[] namesStrings = {"Grace Hopper", "Barbara Liskov", "Ada Lovelace",
            "Karen Spärck Jones"};
    //going through the streams to reach list
    //[] ========> Stream<> ========> List<>
    Stream<String> namesStream = Stream.of(namesStrings);
    Stream<String> stringStream = Arrays.stream(namesStrings);

    List<String> namesList = Stream.of(namesStrings)
        .collect(Collectors.toList());
    System.out.println(namesList);

      List<String> namesList2 = namesStream.collect(Collectors.toList());
      System.out.println(namesList2);


      List<String> namesList3 = stringStream.collect(Collectors.toList());
      System.out.println(namesList3);


    // [] ============> List<>   directly, without using streams
    List<String> stringList = Arrays.asList(namesStrings);
    System.out.println(stringList);


    //1.GOAL
    List<Person> persons = stringList.stream()
                           .map(name -> new Person(name))
                           .collect(Collectors.toList());

    System.out.println(persons);

    //2.GOAL
    //even if it has a default constructor
    // the CONTEXT DICTATES on what constructor to call
    List<Person> personList = stringList.stream()
                            .map(Person::new)
                            .collect(Collectors.toList());
    System.out.println(personList);


     Person person1 = new Person("George Tush");
     Person person2 = new Person("Donald Bump");

     //GOAL: create a stream from an object
     List<Person> personList1 = Stream.of(person1)
             .collect(Collectors.toList());

     //same object
     Person aPerson = personList1.get(0);
     System.out.println(aPerson == person1); //same reference
     System.out.println(aPerson.equals(person1)); //same object


      //using copy constructor
      //break the link
      //unveiling the context:
      //the context is a stream of Person
      //Person::new invokes the constructor
      //that takes a Person
      List<Person> personList2 = Stream.of(person2)
              .map(Person::new)
              .collect(Collectors.toList());
      Person bPerson = personList2.get(0);

      System.out.println(bPerson == person2); //different reference
      System.out.println(bPerson.equals(person2)); //different objects but equivalent


      //varargs constructor
      //we need o varargs constructor for Person
     List<Person> personas =  namesList.stream()   //stream of strings
      .map(name -> name.split(" "))//map to a stream of string arrays
      .map(Person::new) // map to a stream of Person: context is different !!!
      .collect(Collectors.toList()); //just collect

      //do you want an array instead of list?
      //construct an array of Person
      Person[] people  = namesList.stream()
              .map(Person::new)
              .toArray(Person[]::new);

      for(Person p: people) System.out.println(p);

  }

}
