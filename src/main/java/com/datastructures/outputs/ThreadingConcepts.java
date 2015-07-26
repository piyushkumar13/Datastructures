package com.datastructures.outputs;

/**
 * One way using the Runnable interface.
 */
public class ThreadingConcepts implements Runnable {


    public ThreadingConcepts(){
       new Thread(this).start();

    }
    @Override
    public void run() {
       for (int i=0;i<5;i++) {
           System.out.println("This is threading test");
       }
    }

    public static void main(String[] args) {
        ThreadingConcepts concepts = new ThreadingConcepts();
       // we can also run the thread in the following way. Just remove the statement new Thread(this).start from constructor
       // new Thread(concepts).start();
    }
}

class ThreadingConcepts2 extends Thread {

    public ThreadingConcepts2() {
       // super();
        start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("This is threading test");
        }
    }

    public static void main(String[] args) {
        ThreadingConcepts2 concepts2 = new ThreadingConcepts2();
    }
}
