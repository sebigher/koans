package org.nowhere.chap1;

import java.util.List;
import java.util.Scanner;

public class LotteryNumbersCustomPrinting {
    public  static void main(String  ...coco){
        Scanner in = new Scanner(System.in); //attaching the Scanner object to the input
        System.out.println("Let's generate lotto numbers for what lottery(45, 49)");

        List<Integer> integerList = RandomNumberService.getRandomNumbers(in.nextInt());
        OutputService.printNumbers(integerList);
    }
}
