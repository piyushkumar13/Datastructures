package com.datastructures.knowforinterview;

import java.util.*;

public class JavaConcepts {

    private static class Person {

        private String name;
        private int age;
        private int id;

        public Person(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

    private static class AgeComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    static void checkCollectionsSort(){

        List<String> list = new ArrayList<>();

        list.add("Piyush");
        list.add("Diksha");
        list.add("Gaurav");
        list.add("Siri");
        list.add("Birendra");

        Collections.sort(list); // uses merge sort
        System.out.println("list : "+ list);


        int[] arr = new int[]{3,1,9,4};
        Arrays.sort(arr); // uses quick sort
        System.out.println("Array is : " + Arrays.toString(arr));
    }

    void checkLinkedListCollection(){

        LinkedList<String> list = new LinkedList<>();

        /* Following makes the java linked list as the stack. */
        list.addFirst("Piyush");
        list.removeFirst();

        /* Following makes the java linked list as the queue. */
        list.addLast("Kumar");
        list.removeFirst();

        /* Some additional methods of LinkedList. */
        list.getFirst();
        list.getLast();

        /* Reverse a list. */
        Collections.reverse(list);

    }

    static void checkQueue(){

        /*
        We cannot instantiate a Queue directly as it is an interface.
        Instead, we use classes like PriorityQueue, LinkedList that implement the Queue interface.
        Elements follow FIFO (First-In-First-Out) in LinkedList and priority order in PriorityQueue.
        */

        // ############################### FIFO Queue #########################
        Queue<String> queue = new LinkedList<>();
        queue.add("Piyush");
        queue.add("Amogh");
        queue.add("Birendra");
        queue.remove(); // removes element from the front of the queue. It throws exception if queue is empty.
        queue.poll(); // removes element from the front of the queue. It does not throw exception if queue is empty.

        for (String ele: queue){
            System.out.println(ele);
        }

        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        // ############################### Priority Queue - Heap #########################

        Queue<Integer> minHeap = new PriorityQueue<>(); // By default, its min-heap
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap
        Queue<Integer> maxHeap2 = new PriorityQueue<>(Collections.reverseOrder()); // max-heap using Collections.reverseOrder()
        minHeap.add(10);
        minHeap.add(11);
        minHeap.add(9);
        minHeap.poll();
        minHeap.peek();
        minHeap.remove();

        Queue<Integer> maxHeapWithComparator = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1)); // max-heap
        Queue<Person> minHeapWithComparator2 = new PriorityQueue<>(new AgeComparator()); // min-heap as per age comparator
        minHeapWithComparator2.add(new Person("Pk", 36, 1));
        minHeapWithComparator2.add(new Person("Sk", 10, 1));
        minHeapWithComparator2.add(new Person("Uk", 13, 1));
        minHeapWithComparator2.add(new Person("Mk", 20, 1));

        System.out.println("minHeapWithComparator2" + minHeapWithComparator2);
        System.out.println(minHeapWithComparator2.poll());
        System.out.println(minHeapWithComparator2.poll());
        System.out.println(minHeapWithComparator2.poll());
        System.out.println(minHeapWithComparator2.poll());
    }

    public static void checkStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.add(4);

        stack.isEmpty();
        stack.empty();

        int testIntInPrimitive = 5;
        stack.push(testIntInPrimitive);

        System.out.println("Top of stack : " + stack.peek());

        System.out.println("Stack is " + stack);
    }

    public static void checkMap(){

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Piyush");
        map.put(2, "Anand");
        map.put(10, "Abhi");
        map.put(4, "Atul");

        System.out.println("Contains key : " + map.containsKey(10));
        System.out.println("Contains value : " + map.containsValue("Abhi"));

        Set<Integer> keySet = map.keySet();
        System.out.println("Key set is : " + keySet);

        Collection<String> values = map.values();
        System.out.println("Values are " + values);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries){

            System.out.println("Entry is : " + entry.getKey() + " value is : " + entry.getValue());
        }

        /* ###### PutIf ######## */
        String returnTypeOfPutIfIsValue1 = map.putIfAbsent(5, "Sam");
        System.out.println("returnTypeOfPutIfIsValue1 : " + returnTypeOfPutIfIsValue1);

        String returnTypeOfPutIfIsValue2 = map.putIfAbsent(2, "Ahlawat");
        System.out.println("returnTypeOfPutIfIsValue2 : " + returnTypeOfPutIfIsValue2);

        /* ###### ComputeIf ######## */
        String returnTypeOfComputeIsValue1 = map.computeIfPresent(5, (key, value) -> value + " " + "Karan");
        System.out.println("returnTypeOfComputeIsValue1 : " + returnTypeOfComputeIsValue1);

        String returnTypeOfComputeIsValue2 = map.computeIfAbsent(10, key -> "Hello");
        System.out.println("returnTypeOfComputeIsValue2 : " + returnTypeOfComputeIsValue2);

        System.out.println("Map is : " + map);

        String checkDefault1 = map.getOrDefault(5, "My Default");
        String checkDefault2 = map.getOrDefault(11, "My Default");

        System.out.println("checkDefault1 : " + checkDefault1);
        System.out.println("checkDefault2 : " + checkDefault2);

    }

    public static void checkMisc(){

        String str = "ijkac";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String newStr = new String(charArray);

        System.out.println("Unsorted arry : " + str + " Sorted array : " + newStr);

        ArrayList<int[]> result = new ArrayList<>(); // completely valid since Array is object not primitive object.
        int[][] array = result.toArray(new int[result.size()][]);

        Integer[] arrayToReverse = new Integer[]{4,2,5,2,7,1};// cant do reverse with primitive type, for them, we need to reverse manually.
        Arrays.sort(arrayToReverse, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder("cba");
        String reverseSb = sb.reverse().toString();

        int[] arr = new int[]{2,1,5};
        int[] clone = arr.clone();
        System.out.println("Clone array is : " + clone[0]);

        int[] newClonedArray = Arrays.copyOf(arr, arr.length);
        System.out.println("New Clone array is : " + newClonedArray[0]);

        /* Reverse Array of object. */
        String[] strArray = new String[]{"A", "B", "C"};
        Collections.reverse(Arrays.asList(strArray));
        System.out.println("Reverse array is : " + Arrays.toString(strArray));
    }

    public static void main(String[] args) {

        checkCollectionsSort();

        checkQueue();

        checkStack();

        checkMap();

        checkMisc();

    }

}
