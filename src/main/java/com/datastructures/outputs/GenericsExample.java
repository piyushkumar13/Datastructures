package com.datastructures.outputs;

public class GenericsExample<T> {
    private T i;

    public GenericsExample(T i) {
        this.i = i;
    }

    public T getValue() {
        return i;
    }

    public static void main(String[] args) {
        GenericsExample<Integer> example = new GenericsExample<Integer>(50);
        System.out.println("The value of the generic data member is " + example.getValue());

        GenericsExample<String> example1 = new GenericsExample<String>("Piyush Kumar");
        System.out.println("The value of the generic data member is " + example1.getValue());
    }

}

class GenericsWithBoundedTypes<V extends Number> {
    private V value;

    public GenericsWithBoundedTypes(V value) {
        this.value = value;
    }

    public int getValue() {
        //if we dont extend Number then we will get the compilation error in the following line.
        //Because the compiler wont be having any information at the compile time what V would be
        // at runtime. Hence, we cant use any method defined by Number class.Here, it is intValue()
        return value.intValue();
    }

    public static void main(String[] args) {
        GenericsWithBoundedTypes<Integer> boundedTypes = new GenericsWithBoundedTypes<Integer>(473);
        System.out.println("The value of the bounded type is " + boundedTypes.getValue());
    }
}

class ObjectClassGenericBehaviour {

    Object i;

    public ObjectClassGenericBehaviour(Object i) {
        this.i = i;
    }

    Object getValue() {
        return i;
    }

    public static void main(String[] args) {
        ObjectClassGenericBehaviour objectClassGenericBehaviour = new ObjectClassGenericBehaviour(56);
        Integer j = (Integer) objectClassGenericBehaviour.getValue();// here we have to do explicit type casting whereas
        // in generics this is handle automatically internally. The process which accomplishes this is called erasure.
        System.out.println("The value of i is " + j);
        System.out.println(objectClassGenericBehaviour.getValue());

        ObjectClassGenericBehaviour objectClassGenericBehaviour1 = new ObjectClassGenericBehaviour("Piyush Kumar");
        String name = (String) objectClassGenericBehaviour1.getValue();
        System.out.println("The name is " + name);
        System.out.println(objectClassGenericBehaviour1.getValue());

        objectClassGenericBehaviour = objectClassGenericBehaviour1;// here the compiler will not give error since both of them
        // are the references of the Object class.But is conceptually is wrong.
        Integer na = (Integer) objectClassGenericBehaviour.getValue();//Here compiler wont complain but at runtime will give
        // type mismatch error.So, in using Object class approach such kind of errors cant be caught until the runtime
        // In generics, these kind of error will be caught at the compile time.
        System.out.println("Now the value is " + na);
    }
}

class GenericsWithWildCard<T extends Number> {
    T nums[];

    public GenericsWithWildCard(T[] nums) {
        this.nums = nums;
    }

    public Double findAverage() {
        Double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i].doubleValue();
        }
        return sum;
    }

    //Here if we use the type parameter instead of wild card character.It will give the compile time error
// at obj1.compareAverage(obj2). Because I am calling compareAverage method with obj1 which is of type.
// Integer so the type parameter in the method signature also becomes Integer and I am trying to pass
// the object which is of type Double so type mismatch error.
    public boolean compareAverage(GenericsWithWildCard<?> obj) {
        if (this.findAverage() == obj.findAverage()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GenericsWithWildCard<Integer> obj1 = new GenericsWithWildCard<Integer>(new Integer[]{1, 2, 3});
        System.out.println("The average for the integer is " + obj1.findAverage());
        GenericsWithWildCard<Double> obj2 = new GenericsWithWildCard<Double>(new Double[]{1.0, 6.0, 3.0});
        System.out.println("The average for the double is " + obj2.findAverage());

        System.out.println(obj1.compareAverage(obj2));

    }

}

class GenericMethods {

    public static <T extends Number, V extends Number> void add(T num1, V num2) {
        Integer i = num1.intValue() + num2.intValue();
        System.out.println(i);
    }

    public static void main(String[] args) {
        add(10, 15.1);
    }
}

class GenericsAmbiguity<T, V extends String> {

//    T obj1;
//    V obj2;
//
//    public void setObj(T obj1){
//        this.obj1 = obj1;
//    }
//    if we dont extent the String above.We will get the compilation error here itself as it will conclude to the
// same method after erasure(it will conclude to the same erasure).
//    public void setObj(V obj2){
//        this.obj2 = obj2;
//    }
//
//    public static void main(String[] args) {
//        GenericsAmbiguity<String,String> genericsAmbiguity = new GenericsAmbiguity<String, String>();
//        //this will result in to the ambiguos method call.
//        genericsAmbiguity.setObj("adfssa");
//    }
}

class GenericInheritance<T> extends GenericsExample<T> {

    public GenericInheritance(T i) {
        super(i);
    }
}

interface Abc<T, V extends Number> {
    void setName(T t, V v);
}

class Xyz<T, V extends Number> implements Abc<T, V> {

    @Override
    public void setName(T o, V o2) {

    }
}