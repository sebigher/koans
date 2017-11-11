package org.nowhere.abc;

import java.util.ArrayList;
import java.util.List;

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


    }
}
