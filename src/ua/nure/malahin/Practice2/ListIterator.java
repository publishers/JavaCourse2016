//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ua.nure.malahin.Practice2;

import java.util.Iterator;

public interface ListIterator extends Iterator<Object> {
    boolean hasPrevious();

    Object previous();

    void set(Object var1);

    void remove();
}
