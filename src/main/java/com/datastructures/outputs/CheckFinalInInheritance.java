package com.datastructures.outputs;


public class CheckFinalInInheritance {

    public void printName() {
        System.out.println("I am piyush kumar");
    }

    public final void printCompanyName() {
        System.out.println("I am in thermofisher scientific");
    }
}

class Test extends CheckFinalInInheritance {
    public void call() {
        printCompanyName();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.printCompanyName();
        test.printName();

        new CheckFinalInInheritance().printCompanyName();
    }
}
