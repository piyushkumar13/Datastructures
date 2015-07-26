package com.datastructures.outputs;


public enum EnumExample {

    PIYUSH(10) {
        @Override
        public String getA() {
            return "This is piyush";
        }
    }, SHEEL(1) {
        @Override
        public String getA() {
            return "This is sheel";
        }
    };
    private int i;

    EnumExample() {

    }

    EnumExample(int i) {
        this.i = i;

    }

    public int getI() {
        return i;
    }

    abstract public String getA();

    public static void main(String[] args) {
        //one way
        EnumExample a;
        System.out.println("the value of i " + PIYUSH.getI());
        System.out.println(PIYUSH.getA());
        //second way
        EnumExample b = EnumExample.valueOf("SHEEL");
        System.out.println(b.getI());
        System.out.println(b.getA());
        //third way
        EnumExample c = EnumExample.SHEEL;
        System.out.println(c.getI());
        System.out.println(c.getA());

    }

}
//
//class test {
//    public static void main(String[] args) {
//        EnumExample a ;
//        System.out.println("the value of i " + EnumExample.PIYUSH.getI());
//        System.out.println(EnumExample.PIYUSH.getA());
//
//        EnumExample b = EnumExample.SHEEL;
//        System.out.println(b.getI());
//        System.out.println(b.getA());
//
//    }
//}
