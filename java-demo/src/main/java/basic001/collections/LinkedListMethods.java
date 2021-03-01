package basic001.collections;


import java.util.LinkedList;
import java.util.List;

public class LinkedListMethods {

    public static void main(String args[]){
        List list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(0,"e");
        System.out.println(list);
    }

}
