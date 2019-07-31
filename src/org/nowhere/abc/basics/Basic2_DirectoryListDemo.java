package org.nowhere.abc.basics;

import java.io.File;
import java.io.FilenameFilter;

public class Basic2_DirectoryListDemo {
    public static void main(String ...args){
        //define a directory
        File directory = new File("./src/org/nowhere/abc/basics");

        //list the content & do some filtering
        String[] fileList = directory.list();
        System.out.println(fileList); //garbage printing
        printArray(fileList);

        System.out.println("==========filtering with anonymous class========");
        //anonymous class solution
        String[] fileListDemo = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("Demo");
            }
        });

        printArray(fileListDemo);

        System.out.println("==========filtering with lambda========");
        //2. lambda expression
        fileListDemo = directory.list((dir, name) ->
               name.contains("Demo") ); //expression lambda: no return
        printArray(fileListDemo);

        //2.1 explicit parameters types -> all or nothing
        fileListDemo = directory.list((File dir, String name) ->
                name.contains("Demo") );
        printArray(fileListDemo);

        //2.2 Statement lambda: when we are using blocks
        fileListDemo = directory.list(
                (File dir, String name) ->{
                 return name.contains("Demo");
                } //statement lambda
        );
        printArray(fileListDemo);


    }

    private static void printArray(String[] array){
        for(String item: array){
            System.out.println(item);
        }
    }

}
/**
 * @FunctionalInterface
public interface FilenameFilter {
/**
 * Tests if a specified file should be included in a file list.
 *
 * @param   dir    the directory in which the file was found.
 * @param   name   the name of the file.
 * @return  <code>true</code> if and only if the name should be
 * included in the file list; <code>false</code> otherwise.
 *
boolean accept(File dir, String name);
 */