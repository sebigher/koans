package org.nowhere.abc.basics;


//intro in lambdas
public class RunnableDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); //main
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()); //Thread-0
            }
        }).start();

        //zero arguments
        new Thread(() ->
                System.out.println(Thread.currentThread().getName())
        ).start(); //Thread-1

        //assigning lambda expression to variable
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        new Thread(runnable).start();
    }

}
