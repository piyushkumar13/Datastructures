package com.datastructures.outputs;


/**
 * What will be the sequence of the execution if class contains the static block,initializatio block and constructor?<br/>
 * First static block will be executes followed by the initialization block and then the constructor
 */
public class Blocks {

    int i;
    static int j;

    Blocks() {
        System.out.println("inside constructor");
        i = 20;
        System.out.println("value inside constructor is " + i);
    }

    static {
        System.out.println("inside static block");
        j = 30;
        System.out.println("value inside static block is " + j);

    }

    {
        System.out.println("inside initialization block");
        i = 10;
        System.out.println("value inside initialization block is " + i);
    }

    public static void main(String[] args) {
        Blocks blocks = new Blocks();
    }
}
