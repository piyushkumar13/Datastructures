package com.datastructures.outputs;

import java.util.HashSet;

/**
 * Created by kumarp9 on 21/06/15.
 */

public class HashingEquality {

    int i;

    HashingEquality(int i) {
        this.i = i;
    }

    //    @Override
//    public int hashCode() {
//        System.out.println("Hash code called");
//        return super.hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashingEquality that = (HashingEquality) o;

        if (i != that.i) return false;

        return true;
    }

    public static void main(String[] args) {
        HashingEquality obj1 = new HashingEquality(10);
        HashingEquality obj2 = new HashingEquality(10);

        System.out.println(obj1.equals(obj2));

        HashSet<HashingEquality> set = new HashSet<HashingEquality>();
        set.add(obj1);
        System.out.println("adding " + set.add(obj2));
        System.out.println(set.size());
        System.out.println(set.contains(obj2));
    }
}
