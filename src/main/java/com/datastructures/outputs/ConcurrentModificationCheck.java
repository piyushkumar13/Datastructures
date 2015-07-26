package com.datastructures.outputs;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationCheck {

    List<String> names = new ArrayList<String>(){{
        add("piyush");
        add("sheel");
        add("brijesh");
        add("bhatia");
    }};

    public void checkList(){
        Iterator<String> itr = names.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
            //this will throw the concurrent modification exception.Since other than the iterator's own method, other method
            // i.e add of list is trying to change the structure of the list.
            names.add("abc");
        }

        System.out.println("the name at index 1 is :::: "+names.get(1));
    }

    public static void main(String[] args) {
        ConcurrentModificationCheck obj = new ConcurrentModificationCheck();
        obj.checkList();

    }

}
