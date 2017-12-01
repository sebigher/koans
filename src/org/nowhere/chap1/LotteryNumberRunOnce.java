package org.nowhere.chap1;

import java.util.Scanner;

public class LotteryNumberRunOnce {
    public static void main(String ...args){
       Scanner in = new Scanner(System.in); //attaching the Scanner object to the input
       System.out.println("Let's generate lotto numbers for what lottery(45, 49)");
       Integer lottery = in.nextInt();

       RandomNumberService.getRandomNumberWithRetry(lottery + 1 );
    }

}
