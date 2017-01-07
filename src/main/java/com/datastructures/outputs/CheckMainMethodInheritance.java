package com.datastructures.outputs;

/* Since main method is static, it will always get hidden not overriden. */
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
