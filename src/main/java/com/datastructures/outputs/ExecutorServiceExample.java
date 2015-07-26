package com.datastructures.outputs;

import java.util.concurrent.*;

class ABC implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is ABC class of executor service " + i);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }
    }
}

class XYZ implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is XYZ class of executor service " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class CallabeExampleWithString implements Callable<String> {

    private String name;

    public CallabeExampleWithString(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }
}

class CallableExampleWithInt implements Callable<Integer> {

    Integer i, j;

    public CallableExampleWithInt(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Integer call() {
        return i + j;
    }

}

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ABC abc = new ABC();
        XYZ xyz = new XYZ();
        CallabeExampleWithString example = new CallabeExampleWithString("Piyush Kumar");


//        ExecutorService es = Executors.newSingleThreadExecutor();
//        es.execute(abc);
//        es.execute(xyz);

        ExecutorService es = Executors.newFixedThreadPool(10);
        es.execute(abc);
        es.execute(xyz);

        Future<String> exValue = es.submit(example);
        try {
            System.out.println(exValue.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<Integer> exValue2 = es.submit(new CallableExampleWithInt(10,20));
        try {
            System.out.println(exValue2.get());
        }catch (Exception e){

        }

    }
}
