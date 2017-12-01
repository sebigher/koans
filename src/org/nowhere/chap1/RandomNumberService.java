package org.nowhere.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        return number;
    }

    public static void getRandomNumbersForLottery(Integer lottery) {
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

    //still doing 2 things: generating and printing
    public static void getRandomNumbersAndOutput(Integer lottery) {
        switch (lottery) {
            case 45:
                OutputService.printNumbers(generateNumbers(lottery, 5));
                break;
            case 49:
                OutputService.printNumbers(generateNumbers(lottery, 6));
                break;
            default:
                break;
        }

    }

    public static List<Integer> getRandomNumbers(Integer lottery) {
        List<Integer> numbers;
        switch (lottery) {
            case 45:
                numbers = Arrays.asList(generateNumbers(lottery, 5));
                break;
            case 49:
                numbers = Arrays.asList(generateNumbers(lottery, 6));
                break;
            default:
                numbers = new ArrayList<>();
                break;
        }
       return numbers;

    }

    public static List<Integer> getRandomNumbers2(Integer lottery) {
        List<Integer> numbers = new ArrayList<>();
        switch (lottery) {
            case 45:
                numbers = generateListofNumbers(lottery, 5);
                break;
            case 49:
                numbers = generateListofNumbers(lottery, 6);
                break;
            default:
                break;
        }
        return numbers;

    }




    private static void generateAndPrintNumbers(int lottery, int draw) {
        for (int i = 1; i <= draw; i++) {
            System.out.print("#" + i + " ");
            getRandomNumberCorrect(lottery);
        }
    }

    private static Integer[] generateNumbers(int lottery, int draw) {
        Integer[] numbers = new Integer[draw];
        for (int i = 0; i < draw; i++) {
            numbers[i] = getRandomNumberCorrect(lottery);
        }
        return numbers;
    }

    private static List<Integer> generateListofNumbers(int lottery, int draw){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < draw; i++) {
            numbers.add(getRandomNumberCorrect(lottery));
        }
        return numbers;
    }



}
