package org.nowhere.abc.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interm3_Function {
    public static void main(String ...args) {
      // R apply(T t)
       //common use case: Stream.map(Function)
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        //anonymous inner class
        List<Integer> namesLengths = names.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }).collect(Collectors.toList());

        //lambda expression
        namesLengths = names.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        //methid reference
        namesLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());


    }
}
