package org.nowhere.abc.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferences {
    public static void main(String ...args){
        //////////////////////////
        Stream.of(3, 1, 4, 5.1)
                .forEach(System.out::println);

        Stream.of(3, 1, 4, 5.1)
                .forEach(x -> System.out.println(x));

        Consumer<Integer> consumer = x -> System.out.println(x ); //object::instanceMethod
        Consumer<Integer> consumer1 = System.out::println;

        Stream.generate(Math::random) //method reference to static method Class::staticMethod
                .limit(20)
                .forEach(System.out::println);

        //////////////////////////

        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(string -> string.length())
                .sorted()
                .forEach(string -> System.out.println());


        Stream.of("this", "is", "a", "stream", "of", "strings")
                .map(String:: length)
                .sorted()
                .forEach( System.out::println);


        ////////////////////////////
        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());


        List<String> string =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted2 = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());



    }
}
