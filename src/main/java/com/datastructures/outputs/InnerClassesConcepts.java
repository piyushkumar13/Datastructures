package com.datastructures.outputs;

/**
 * Actually inner classes is like the normal member of the class. So, all the rules which <br/>
 * applies to the members of the classes, also applied to the inner classes.(considering static<br/>
 * members of the classes)
 */
public class InnerClassesConcepts {

    private String name;
    private static String lastName;

    class XYZ {

        void getNameFromNonStaticInnerClass() {
            name = "Piyush";
            System.out.println("The full name from the non-static class is " + name + " " + lastName);
        }
    }

    static class ABC {

        void getName() {
            lastName = "Kumar";
            InnerClassesConcepts obj = new InnerClassesConcepts();
            obj.name = "Piyush";
            System.out.println("The full name is :::" + lastName + obj.name);
        }
    }

    public static void getN() {
        System.out.println("this is static method " + lastName);
    }

    public void createObj() {

        ABC abc = new ABC();
        abc.getName();
        System.out.println("creating object in createObject() method");
        XYZ xyz = new XYZ();
        xyz.getNameFromNonStaticInnerClass();
    }

    public static void main(String[] args) {

        InnerClassesConcepts concepts = new InnerClassesConcepts();
        concepts.createObj();

        ABC obj = new ABC();
        obj.getName();

        XYZ xyz = new InnerClassesConcepts().new XYZ();
        xyz.getNameFromNonStaticInnerClass();
    }
}

class OtherClass {

    public static void main(String[] args) {
        InnerClassesConcepts.getN();
        InnerClassesConcepts.ABC abc = new InnerClassesConcepts.ABC();
        abc.getName();
        InnerClassesConcepts concepts = new InnerClassesConcepts();
        InnerClassesConcepts.XYZ xyz = concepts.new XYZ();
        xyz.getNameFromNonStaticInnerClass();
        InnerClassesConcepts.getN();

    }
}
