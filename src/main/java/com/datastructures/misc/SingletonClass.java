package com.datastructures.misc;

public class SingletonClass {

    private static SingletonClass singleObj = new SingletonClass();

    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        return singleObj;
    }

    public void printSomeThing() {
        System.out.println("This is the example of singleton class");
    }

    public static void main(String[] args) {
        SingletonClass obj = getInstance();
        obj.printSomeThing();
    }
}
