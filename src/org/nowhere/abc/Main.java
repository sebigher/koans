package org.nowhere.abc;

import org.nowhere.abc.basics.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
     // jdk 1.5 - 6
     List<String> strings = new ArrayList<String>();
     System.out.println(strings);

     //jdk 1.7 diamond operator
     List<String> ops = new ArrayList<>();

     //can you add primitive types to a list?
     //thanks to autoboxing, you can
     List<Integer> ints = new ArrayList<>();
     ints.add(1);ints.add(5);
     System.out.println(ints); //[1, 5]

     System.out.println(valueOf(4 <= 5));
     System.out.println(valueOf(3 > 9));

     Person john = new Person("John");

     Map<String, Person> mapper = new HashMap<>();
     mapper.putIfAbsent("a", john);
     mapper.putIfAbsent("a", new Person("Johnny"));
     mapper.putIfAbsent("b", john);
     System.out.println(mapper);
    }

    //translating
    public static Boolean valueOf(boolean boo){
        return boo ? Boolean.TRUE : Boolean.FALSE;
    }

}
