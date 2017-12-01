package org.nowhere.chap1;

import java.util.List;

public class OutputService {

    //all the numbers
    public static void printNumbers(int[] draw){
        for(int i = 0; i < draw.length; i++){
            System.out.println("#: i " +  "candidate number " + draw[i]);
        }
    }

    //all the numbers
    public static void printNumbers(Integer[] draw){
        for(int i = 0; i < draw.length; i++){
            System.out.println("#: i " +  "candidate number " + draw[i]);
        }
    }

    //all the numbers
    public static void printNumbers(List<Integer> draw){
        for(Integer number: draw){
            System.out.println("#: i " +  "candidate number " + number);
        }
    }


}
