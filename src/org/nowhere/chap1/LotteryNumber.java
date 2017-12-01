package org.nowhere.chap1;

import java.util.Random;

//run program 6 times and write down the results
//problems: we are not generating all the numbers at once
//could be that we generate the same number twice?
public class LotteryNumber {
    public static void main(String... args) {
        int number = new Random().nextInt(50); // [0, 50)

        System.out.println("number: " + number);
        if (number > 0) { //could be 0
            System.out.println("Possible candidate: " + number);
        }
    }
}
