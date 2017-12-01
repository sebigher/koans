package org.nowhere.chap1;

public class OutputService {

    //all the numbers
    public static void printNumbers(int[] draw){
        for(int i = 0; i < draw.length; i++){
            System.out.println("#: i " +  "candidate number " + draw[i]);
        }
    }

}
