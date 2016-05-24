//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ua.nure.malahin.Practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyListImpl implements MyList, ListIterable {
    private int arrSize = 2;
    private Object[] arr;
    private int size;

    public MyListImpl() {
        arr = new Object[arrSize];
        size = 0;
    }

    public void add(Object e) {
        if (arr.length <= size) {
            resize();
            arr[size++] = e;
        } else {
            arr[size++] = e;
        }

    }

    public void clear() {
        arr = new Object[arrSize];
    }

    public boolean remove(Object o) {
        boolean bool = false;

        for (int i = 0; i < arr.length; ++i) {
            if (o.equals(arr[i])) {
                bool = true;
                deleteByIndex(i);
                break;
            }
        }

        return bool;
    }

    public Object[] toArray() {
        Object[] tmp = new Object[size];

        for (int i = 0; i < size; ++i) {
            tmp[i] = arr[i];
        }

        return tmp;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(Object o) {
        boolean contains = false;
        Object[] tmp = arr;
        for (int i = 0; i < size; ++i) {
            if (o.equals(tmp[i])) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    private void resize() {
        Object[] newArr = new Object[(int) (arr.length * 1.5D)];

        for (int i = 0; i < arr.length; ++i) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    private void deleteByIndex(int indexDel) {
        --size;

        for (int i = indexDel; i < size; ++i) {
            arr[i] = arr[i + 1];
        }

    }

    public boolean containsAll(MyList c) {
        boolean containsAll = false;
        Object[] tmp = c.toArray();
        int countEquals = 0;
        int i = 0;

        while (i < tmp.length) {
            int j = 0;

            while (true) {
                if (j < size) {
                    if (!arr[j].equals(tmp[i])) {
                        ++j;
                        continue;
                    }

                    ++countEquals;
                }

                ++i;
                break;
            }
        }

        if (countEquals == tmp.length) {
            containsAll = true;
        }

        return containsAll;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for (int i = 0; i < size; ++i) {
            sb.append("[");
            sb.append(arr[i]);
            sb.append("]");
            if (i < size - 1) {
                sb.append(',');
            }
        }

        sb.append('}');
        return sb.toString();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        private boolean isCalledPrevious;
        private boolean isCalledSet;

        public boolean hasPrevious() {
            return step - 1 >= 0;
        }

        public Object previous() {
            isCalledSet = false;

            if (isCalledNext()){
                step--;
            }

            if (isCalledPrevious){
                step--;
            }

            if (step < 0) {
                throw new NoSuchElementException();
            } else {
                isCalledPrevious = true;
                setCalledNext(false);
                setCalledRemove(false);

                return MyListImpl.this.arr[step];
            }
        }

        public void set(Object e) {
            if (!isCalledPrevious && !isCalledNext() || (!isCalledNext() && isCalledSet) || isCalledRemove()) {
                throw new IllegalStateException();
            }

            isCalledSet = true;
            arr[step >= 0 ?
                    (isCalledPrevious  ? step :
                            (isCalledNext() ? step - 1 : 0))
                    : -1] = e;

            if(!isCalledPrevious){
                isCalledPrevious = false;
            }
            else {
                setCalledNext(false);
            }

        }

        public void remove() {
            if ((isCalledPrevious || isCalledNext()) && !isCalledRemove() && !isCalledSet ) {
                MyListImpl.this.deleteByIndex(
                        step - 1 >= 0 ?
                        (
                                isCalledNext() ?
                                        step - 1 :
                                        (
                                                isCalledPrevious ? step : 0
                                        )
                        )
                        : 0
                );
                if(size + 1 == step) --step;
                --step;
                isCalledPrevious = false;
                setCalledNext(false);
                setCalledRemove(true);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private class IteratorImpl implements Iterator<Object> {
        private boolean isCalledNext;
        private boolean isCalledRemove;
        protected int step;

        private IteratorImpl() {
            isCalledNext = false;
            isCalledRemove = false;
            step = 0;
        }

        public boolean hasNext() {
            return MyListImpl.this.size > this.step;
        }

        public Object next() {
            isCalledNext = true;
            isCalledRemove = false;
            if (size > step) {
                return arr[this.step++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (!isCalledNext) {
                throw new IllegalStateException();
            } else if (isCalledRemove) {
                throw new IllegalStateException();
            } else {
                isCalledRemove = true;
                MyListImpl.this.deleteByIndex(this.step - 1 > 0 ? this.step - 1 : (this.step - 1 < 0 ? - 1 : 0));
                step--;
            }
        }

        public boolean isCalledNext() {
            return isCalledNext;
        }

        public boolean isCalledRemove() {
            return isCalledRemove;
        }

        public void setCalledNext(boolean isCalledNext) {
            this.isCalledNext = isCalledNext;
        }

        public void setCalledRemove(boolean isCalledRemove) {
            this.isCalledRemove = isCalledRemove;
        }
    }
}