package org.nowhere.abc.basics;


//intro in lambdas
//functional interface


 /**
@FunctionalInterface
public interface Runnable {

     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     *
    public abstract void run();  // SAM single abstract method
*/
 //match the interface: match the arguments types and the return type(matching the types)
// lambda expression must be compatible with the method signature
public class Basic1_RunnableDemo {

    public static void main(String[] args) {
        //start a thread and run on Runnable object: object of anonymous class
        //implementing Runnable interface --> method run() on some logic
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
