package org.nowhere.abc.basics;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic3_MethodReferenceDemo {
    public static void main(String ...kuku) {
        //THNK: make a stream out of an array
        //it will not work with primitives types !!!
        //remember, autoboxing is not working directly on the array reference!
        //1. first way
        Integer[] numbers = {3, 7, 9, 3, 6, 0};
        Stream<Integer> integerStream = Arrays.stream(numbers);

        //second way
        Stream<Integer> integerStream1 = Stream.of(3, 7, 8, 9, 2);
        System.out.println(integerStream1.getClass().getCanonicalName());

       //3.way
        System.out.println(Stream.of(numbers));
        Consumer<Integer> integerConsumer = x -> System.out.println(x);
        Stream.of(numbers).forEach(integerConsumer);
        System.out.println();
        printer(numbers);

        //using methof reference

        Stream.of(numbers).forEach(System.out::println);

        //object::instanceMethod
        Consumer<Integer> integerConsumer1 = System.out::print;
        Stream.of(numbers).forEach(integerConsumer1);

        //Class::staticMethod

        //object::staticMethod
        Consumer<String> stringConsumer = String::length;

        //Supplier // get me some
        Supplier<Double> supplier = Math::random;

        System.out.println();
        Stream.generate(Math::random)
        .limit(6)
        .forEach(System.out::println);


        //there is always a context for lambda expressions
        //this context is responsable in suppying arguments


        //Comparator
        String[] strings = {"You", "complete", "me"};
        Stream<String> stringStream = Stream.of(strings);
        stringStream.sorted((s1, s2) ->
         s1.compareTo(s2)
        ).collect(Collectors.toList());

        Stream<String> stringStream2 = Stream.of(strings);
        stringStream2.sorted(String::compareTo)
                .collect(Collectors.toList());








    }

    //the Consumer interface has only one SAM: accept
    //just want the body
    private static void printer(Integer[] numbers){
          Arrays.stream(numbers).forEach(x ->
            System.out.print(" " + x)
        );

    }

}

/**
 @FunctionalInterface
 public interface Consumer<T> {

  * Performs this operation on the given argument.
  *
  * @param t the input argument

void accept(T t);


     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null

    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

 * Represents a supplier of results.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
@FunctionalInterface
public interface Supplier<T> {

     * Gets a result.
     *
     * @return a result
    T get();
}


*/