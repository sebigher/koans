package org.nowhere.abc.intermediate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Interm4_Stream1 {
    public static void main(String ...gugu){
        //streams: don't save the elements
        //don't modify the original source
        // pipeline --> terminal expression

        //streams can be used only once
        // streams are lazy

        //1.THNQ create streams
        /**
         * @SafeVarargs
        public static<T> Stream<T> of(T... values) {
           return Arrays.stream(values);
        }
         */

        List<String> dataStringList = Stream.of("aaa", "bbb", "Ccc")
                .collect(Collectors.toList());

        //The API includes overloads of Arrays.stream
        // for arrays of int, long, and double,
        // as well as the generic type used here.
        String[] dataStrings = {"aaa", "bbb", "Ccc"};
        List<String> stringList = Arrays.stream(dataStrings)
                .collect(Collectors.toList());

        //2.THNQ using Stream iterate
        List<BigDecimal> numbs = Stream.iterate(BigDecimal.ONE, n ->
                n.add(BigDecimal.ONE))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(numbs);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

        //3. THNQ Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        
    }
}
