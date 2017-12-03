package org.nowhere.abc.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Interm2_Supplier {
    public static void main(String ...args){
        //T get()

        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return 0;
            }
        };

        randomSupplier = () -> Math.random();
        randomSupplier = Math::random;

        System.out.println(randomSupplier.getAsDouble());
        System.out.println(randomSupplier);

        Logger logger = Logger.getLogger("some");
        logger.info(new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf(1);
            }
        });

        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoë", "Jayne", "Simon", "River", "Shepherd Book");

        Optional<String> first = names.stream()
        .filter(name -> name.startsWith("S")) //test for empty with 'C"
        .findFirst();

        System.out.println(first);
        System.out.println(first.orElse("None"));


        //this will get printedd also
        System.out.println(first.orElse(String.format("No result found in %s", names.stream()
                .collect(Collectors.joining(", ")))));


        //this is invoked only when the Optional is empty
        //deferred execution : primary use-cases for Supplier
        System.out.println(first.orElseGet( () ->
        String.format("No results in %s", names.stream()
         .collect(Collectors.joining(", ")))));




    }
}
