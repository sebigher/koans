package org.nowhere.chap1;

import java.util.Scanner;

public class LotteryNumberRunAll {

    public  static void main(String  ...coco){
        Scanner in = new Scanner(System.in); //attaching the Scanner object to the input
        System.out.println("Let's generate lotto numbers for what lottery(45, 49)");

       RandomNumberService.getRandomNumbersForLottery(in.nextInt());
    }
}
