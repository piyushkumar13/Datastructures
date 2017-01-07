package com.datastructures.outputs;

public class CheckInheritance {

    public void set() {
        System.out.println("this is parent");
    }
}

class MyChildClass extends CheckInheritance {
    public void set() {
        System.out.println("this is child");
    }

    public static void main(String[] args) {
        CheckInheritance checkInheritance = new MyChildClass();
        checkInheritance.set();
    }

}

/* this shows the difference between the compile time and the runtime polymophism

public class CheckInheritance {

    public void set1() {
        System.out.println("this is parent");
    }
}

class MyChildClass extends CheckInheritance {
    public void set() {
        System.out.println("this is child");
    }

    public static void main(String[] args) {

        CheckInheritance checkInheritance = new MyChildClass();
        checkInheritance.set();
    }

}
*/

