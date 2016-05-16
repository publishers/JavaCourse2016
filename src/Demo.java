// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)


import ua.nure.malahin.Practice2.ListIterator;
import ua.nure.malahin.Practice2.MyListImpl;

public class Demo {
    public Demo() {
    }

    public static void main(String[] args) {
        MyListImpl con = new MyListImpl();
        con.add("A");
        con.add("O");

        con.add("O");
        MyListImpl con2 = new MyListImpl();
        con2.add("A");
        con2.add("O");
        con2.add("A1");
        con2.add("2");
        ListIterator iter = con.listIterator();
//        System.out.println(iter.hasPrevious());
//        iter.next();
//        iter.next();
//        iter.previous();
//        iter.previous();
//        iter.previous();
//        iter.set("K");
        System.out.println(con.containsAll(con2));
//        iter.remove();
//        iter.previous();
//        iter.remove();
//        iter.previous();
//        iter.next();
//        iter.remove();

    }
}
