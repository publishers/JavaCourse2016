# Java Tasks from Epam 2016
<pre>
 Practice2
Skip to end of metadata
Go to start of metadata

На странице представлена информация по практическому заданию №2

 
	

Проект должен называться Practice2.
Корневой пакет для всех классов - ua.nure.your_last_name.Practice2.
В корневом пакете должен располагаться класс Demo, который демонстрирует работу всех частей. 

 
Part 1

1.1. Создать интерфейс MyList следующего содержания:
public interface MyList {
    void add(Object e); // appends the specified element to the end of this list 
    void clear(); // removes all of the elements from this list
    boolean remove(Object o); // removes the first occurrence of the specified element from this list
    Object[] toArray(); // returns an array containing all of the elements in this list in proper sequence
    int size(); // returns the number of elements in this list
    boolean contains(Object o); // returns true if this list contains the specified element.
    boolean containsAll(MyList c); // returns true if this list contains all of the elements of the specified list
}

1.2. Создать класс MyListImpl, который реализует MyList.

1.3. Переопределить метод toString таким образом, чтобы результат выводился в виде:

{[результат вызова toString для элемента 1], [результат вызова toString для элемента 2], ... }

1.4. Создать класс Demo, который демонстрирует работу всех методов контейнера. Контейнер заполнять объектами строками, обертками для чисел и т.п.

Например, так:
MyList con = new MyListImpl();
con.add("A");
con.add("B");
con.add(433);
con.add(888);
con.add(new Object());
...

 
Part 2

2.1. Добавить к интерфейсу MyList наследование интерфейса Iterable<Object> (java.lang.Iterable).
MyList extends Iterable<Object>

Реализовать в контейнере MyListImpl метод
public Iterator<Object> iterator() {
    return new IteratorImpl();
}

который возвращает объект внутреннего класса IteratorImpl:
private class IteratorImpl implements Iterator<Object> {
    public boolean hasNext() { // returns true if the iteration has more elements
        // ...
    }
 
    public Object next() { // returns the next element in the iteration
        // ...
    }
      
    public void remove() { // removes from the underlying collection the last element returned by this iterator
        // ...
    }        
}

Алгоритм в методе remove может быть следующим:

ЕСЛИ ПЕРЕД ВЫЗОВОМ remove НЕ БЫЛ ВЫЗВАН МЕТОД next
ИЛИ ПЕРЕД ВЫЗОВОМ remove БЫЛ ВЫЗВАН remove (повторный вызов remove)
    ТО ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ (так и вставить в код): throw new IllegalStateException();
В ДАННОМ МЕСТЕ ОПРЕДЕЛИТЬ И УДАЛИТЬ СООТВЕТСТВУЮЩИЙ ЭЛЕМЕНТ

 

2.2. Продемонстрировать работу итератора с помощью циклов while и for each:
MyListImpl con = new MyListImpl();
// ...
          
for (Object o : con) {
    System.out.println(o);
}
          
Iterator<Object> it = con.iterator();
while (it.hasNext())
    System.out.println(it.next());

 
Part 3

3.1. Определить интерфейс ListIterator:
interface ListIterator extends Iterator<Object> { // java.util.Iterator
    boolean hasPrevious(); // returns true if this list iterator has more elements when traversing the list in the reverse direction
    Object previous(); // returns the previous element in the list and moves the cursor position backwards
    void set(Object e); // replaces the last element returned by next or previous with the specified element 
    void remove(); // removes from the list the last element that was returned by next or previous
}

Методы set/remove могут быть вызваны только после next/previous. Повторный вызов (подряд) set/remove влечет выброс исключения IllegalStateException (см. п. 2.1.)

3.2. Создать интерфейс ListIterable:
interface ListIterable {
    ListIterator listIterator();
}

3.3. Добавить к классу MyListImpl реализацию интерфейса ListIterable:
class MyListImpl implements MyList, ListIterable {...}

3.4. Добавить в класс MyListImpl метод
public ListIterator listIterator() {
    return new ListIteratorImpl();
}

который возвращает объект внутреннего класса ListIteratorImpl:
private class ListIteratorImpl extends IteratorImpl implements ListIterator {
    // IMPLEMENT ALL METHODS HERE!!!
}

3.5. Продемонстрировать работу итератора ListIterator.
</pre>
