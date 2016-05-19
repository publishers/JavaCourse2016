// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)


import ua.nure.malahin.Practice2.ListIterable;
import ua.nure.malahin.Practice2.ListIterator;
import ua.nure.malahin.Practice2.MyList;
import ua.nure.malahin.Practice2.MyListImpl;

import java.util.Iterator;

public class Demo {
    public Demo() {
    }

    public static void main(String[] args) {
        MyListImpl con = new MyListImpl();
        con.add("A");
        con.add("B");

        con.add("T");

        ListIterator iter = con.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        iter.next();
        iter.set("P");
        iter.previous();
        iter.remove();

//        System.out.println(iter.previous());
//        System.out.println(iter.previous());
        System.out.println(iter.previous());


//        System.out.println(iter.previous());
//        iter.remove();
//        System.out.println(iter.previous());
//        iter.remove();
//        System.out.println(iter.previous());
////        System.out.println(iter.next());
//        iter.remove();
//        con.add("T");
//        System.out.println(iter.next());
//        System.out.println(iter.next());
//        con.add("T");
        System.out.println(con);

    }
}
