package com.cit360;

import java.util.*;
//import java.util.Set;
//import java.util.TreeSet;

public class set {
    public static void main(String[] args) {
        int setNumbers[] = {1, 4, 2, 5, 3, 4, 2, 3, 5};
        //List stores ordered collection of data it also allows duplicate values as well
        System.out.println("----------List-----------");
        System.out.println("List stores ordered collection of data it also allows duplicate values as well");
        System.out.println("This code will add these numbers in order - 1, 4, 2, 5, 3, 4, 2, 3, 5");
        List<Integer> list = new ArrayList<>();
        //add all elements from setNumbers to the List
        for (int i = 0; i < setNumbers.length; i++) {
            list.add(setNumbers[i]);
        }
        System.out.println("The printed results will be 1, 4, 2, 5, 3, 4, 2, 3, 5 as shown below: ");
        System.out.println(list);

        //sorted.
        System.out.println("When it is sorted, it will be be - ");
        Collections.sort(list);
        System.out.println(list);


        //Queue
        System.out.println("\n\n\n----------Queue-----------");
        System.out.println("List stores ordered collection of data it also allows duplicate values as well");
        System.out.println("This code will add these numbers in order - 1, 4, 2, 5, 3, 4, 2, 3, 5");
        Queue q = new PriorityQueue();
        for (int i = 0; i < setNumbers.length; i++) {
            q.add(setNumbers[i]);
        }
        System.out.println("The printed results will 1, 3, 2, 3, 4, 4, 2, 5, 5 as shown below: ");
        System.out.println(q);


        //A set is an unordered collection of objects in where duplicate values cannot be stored.
        System.out.println("\n\n\n----------Set-----------");
        System.out.println("A set is an unordered collection of objects in where duplicate values cannot be stored.");
        System.out.println("This code will add these numbers in order - 1, 4, 2, 5, 3, 4, 2, 3, 5");
        Set setExample = new TreeSet();
        //add all elements to the set
        for (int i = 0; i < setNumbers.length; i++) {
            setExample.add(setNumbers[i]);
        }
        System.out.println("The printed results will be 1,2,3,4,5 as shown below: ");
        System.out.println(setExample);



        //Trees are hierarchical data structures. The top most is called the root and the elements under another
        // element are called children.
        System.out.println("\n\n\n----------Tree-----------");
        System.out.println("This code will add these values: Memory, Acapulco, Surface, Pressure, Syrup, Village, stack");
        //add all elements to the set

        TreeSet tree = new TreeSet();
        tree.add("Memory");
        tree.add("Acapulco");
        tree.add("Surface");
        tree.add("Pressure");
        tree.add("Syrup");
        tree.add("Village");
        tree.add("Stack");

        Iterator lists = tree.iterator();
        while(lists.hasNext()) {
            Object element = lists.next();
            System.out.print(element + "\n");
        }
    }
}
