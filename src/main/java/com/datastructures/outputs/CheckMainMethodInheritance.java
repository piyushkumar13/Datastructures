package com.datastructures.outputs;


class ParentClass{

    public static void main(String[] args) {
        System.out.println("This is the parent main method");
    }

}

public class CheckMainMethodInheritance extends ParentClass {

    public static void main(String[] args) {
        System.out.println("This is the child main method");
    }
}
