package org.nowhere.chap1;

import java.util.Random;

public class RandomNumberService {

    public static int getRandomNumberWithRetry(Integer lottery) {
        int number = new Random().nextInt(lottery); // [0, 50)
        // if it's 0 run again
        if (number > 0) { //could be 0
            System.out.println("Possible candidate: " + number);
            return number;
        } else {
            number = new Random().nextInt(lottery);
        }
        return number; //meaning the number 0
    }


    public static int getRandomNumberCorrect(Integer lottery) {

        int number;
        do {
            number = new Random().nextInt(lottery);
        } while (number == 0); //as long as
        System.out.println("candidate number: " + number);
        return number;
    }

    public static void getRdndomNumbersForLottery(Integer lottery) {
        switch (lottery) {
            case 45:
                generateAndPrintNumbers(lottery, 5);
                break;
            case 49:
                generateAndPrintNumbers(lottery, 6);
                break;
            default:
                break;
        }

    }

    private static void generateAndPrintNumbers(int lottery, int draw) {
        for (int i = 1; i <= draw; i++) {
            System.out.print("#" + i + " ");
            getRandomNumberCorrect(lottery);
        }
    }


}
