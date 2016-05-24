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
        iter.set("J");
        iter.next();
        iter.set("Y");
        iter.next();
        iter.set("P");
        System.out.println(con);

        System.out.println(iter.previous());
        iter.remove();
        System.out.println(iter.previous());
        iter.set("W");
//        iter.remove();
        System.out.println(iter.previous());
        iter.remove();
//        iter.set("E");
        System.out.println(con);

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        for (Object o : con) {
            System.out.println(o);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        Iterator<Object> it = con.iterator();
        while (it.hasNext())
            System.out.println(it.next());

    }
}
