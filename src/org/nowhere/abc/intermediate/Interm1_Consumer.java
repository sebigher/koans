package org.nowhere.abc.intermediate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Interm1_Consumer {

    public static void main(String ...arggg){
        //void qccept(T t)
        //default Consumer<T> andThen(Consumer<? super T> after)


        List<String> strings = Arrays.asList("All", "together", "now");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(System.out::println);


        int[] numbs = {5, 6, 2, 8, 5};
        //THNQ let's make a stream
        //from an array
        Arrays.stream(numbs)
                .forEach(System.out::println);
        // from the context we have IntConsumer

        //Other use-cases
        //Optional.ifPresent(Consumer<? super T> consumer)

        //Stream.forEach

        //Stream.peek


    }

}
