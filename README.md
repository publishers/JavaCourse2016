# JavaEPAMSpring2016

<pre>
<h1>Задание 1</h1>

Создать дочерний поток, который бы в течение примерно 5 сек печатал свое имя каждые полсекунды. Сделать это двумя способами - при помощи расширения класса Thread и при помощи реализации интерфейса Runnable.
<h1>Задание 2</h1>

Создать класс Spam, который получает массив интервалов времени в миллисекундах и согласованный с ним массив сообщений, и выводит соответствующие сообщения на экран через заданные интервалы времени. По нажатию на клавишу Enter приложение должно завершать свою работу (данную функциональность поместить в метод Spam.main). При демонстрации работы смоделировать ввод Enter через 5 сек (данную функциональность поместить в метод Part2.main).
<h1>Задание 3</h1>

Создать класс с двумя отдельными счетчиками и объект этого класса. Создать несколько одинаковых потоков, каждый из которых повторяет следующее: сравнивает значение счетчиков и печатает результат сравнения, увеличивает первый счетчик, засыпает на 10 мсек, а затем увеличивает второй счетчик. Сравнить работу программы при условии, что упомянутый блок кода синхронизирован и не синхронизирован.
<h1>Задание 4</h1>

Распараллелить задачу поиска максимального значения в матрице MxN при помощи M потоков. Каждую операцию сравнения снабдить задержкой в 1 мс. Создать и заполнить матрицу 4x100 случайными числами. Дополнительно решить задачу поиска максимального значения без распараллеливания. Вывести результат и время выполнения кода для обоих вариантов.
<h1>Задание 5</h1>

Писатель пишет в буфер, после этого буфер последовательно считывают читатели (вначале один, потом другой и т.д.). После того, как все читатели прочитают буфер, процесс повторяется.

    В качестве буфера можно использовать StringBuilder. Записывать символы с некоторой задержкой (писатель - отдельный поток).
    Каждый читатель - отдельный поток (ограничить задачу тремя потоками).
    Процессы записи и чтения должны быть визуализированны, т.е. чтобы видно было как писатель пишет, а читатели считывают. Можно дублировать записываемые и считываемые символы на экран, при этом для писателя можно использовать System.err - что приведет к выводу символов красным цветом (актуально для Eclipse IDE).
    Ограничить число тактов записи/чтения_всеми_читателями тремя тактами.
    Полное выполнение демонстрирующей программы - не более 5 с.
    п 1. и п.3 неактуальны - использовать пример-заглушку (класс Part51), в ней писатель и читатели уже написаны, необходимо привнести синхронизацию.

Данное задание решить тремя способами (время выполнения задания 5 - не более 15 с):

    Синхронизацию записи/чтения реализовать с помощью классической блокирующей синхронизации (synchronized). Замечание: из исходного кода заглушки ничего не удалять, код только добавлять или переставлять местами строки кода. Возможно потребуется несколько мониторов. Не добавлять код, который содержит вызов метода Thread#join. Программа должна быть устойчивой к изменению констант - количество тактов чтения/записи; размер буфера; задержка при записи/чтении, т.е. после изменения данных параметров приложение должно работать правильно. Для проверки можно написать класс, в котором многократно вызывать Part51.main (например, 50 раз; в конечный код данную функциональность не включать!).
    Синхронизацию записи/чтения реализовать с помощью объекта ReentranLock. Для синхронизации читателей использовать объект Condition, который связан с объектом ReentranLock.
    То же, что и способ 2, но не использовать Condition.

 
	

п. 2 и п. 3 для решения дома. Вначале изучить классы ReentrantLock и Condition, затем решить.
 Пример вывода
Writer writes:YGUZE
Reader Thread-1:YGUZE
Reader Thread-2:YGUZE
Reader Thread-3:YGUZE
Writer writes:JCQZN
Reader Thread-3:JCQZN
Reader Thread-2:JCQZN
Reader Thread-1:JCQZN
Writer writes:NNUPQ
Reader Thread-1:NNUPQ
Reader Thread-2:NNUPQ
Reader Thread-3:NNUPQ
<h1>Задание 6</h1>

Создать десять потоков, которые одновременно пишут в один и тот же файл цифры:

первый поток пишет цифру 0 ровно 20 раз на 1й строке файла;
второй поток пишет цифру 1 ровно 20 раз на 2й строке файла;
...
девятый поток пишет цифру 9 ровно 20 раз на 10-й строке файла.

Для записи использовать класс RandomAccessFile (допускается использование не более одного объекта этого класса). Перед началом работы файл в который будет происходить запись должен быть удален, если он существует. Главный поток, после запуска дочерных потоков на выполнение, должен дождаться их завершения, после чего вывести в консоль содержимое файла.

Замечание. Метод RandomAccessFile#seek(long) позволяет передвигать указатель внутри файла. Каждый поток должен знать в каком месте файла ему записывать информацию. Так как в условии фигурирует термин "строка", следует вывод каждого потока (как выведет все 20 цифр) завершать ограничителем строки (помните про необходимость кросс-платформенности). Для того, чтобы записать некоторую цифру можно использовать выражение '0'+ n, где n - цифра от 0 до 9 включительно. Передвижение указателя внутри файла и запись информации необходимо синхронизировать.
 Пример вывода

00000000000000000000
11111111111111111111
22222222222222222222
33333333333333333333
44444444444444444444
55555555555555555555
66666666666666666666
77777777777777777777
88888888888888888888
99999999999999999999
<h1>Примеры</h1>
 Пример моделирования нажатия на Enter (для задания №2)
import java.io.ByteArrayInputStream;
import java.io.InputStream;
 
 
public class Main {
     
    // terminates an execution per one second
    public static void main(String[] args) throws Exception {
        // save standard input
        InputStream stdIn = System.in;
 
        // create input stream with line terminator (=ENTER)
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
 
        // move internal pointer of input stream to the end of input
        bais.skip(System.lineSeparator().length());
 
        // assign new value of standard input
        System.setIn(bais);
 
        // main functionality
        Thread thread = Test.main();
 
        // waith for 1 sec
        Thread.sleep(1000);
        System.out.println("Try to send enter to standard input");
 
        // move internal pointer to begin of input
        bais.reset();
 
        // wait for a child termination
        thread.join();
         
        // restore standard input
        System.setIn(stdIn);
    }
}
import java.io.IOException;
 
public class Test extends Thread {
 
    public static Thread main() throws Exception {
 
        // run a child thread
        final Thread child = new Thread() {
            public void run() {
                while (!isInterrupted()) {
                    try {
                        System.out.println("Child works");
                        Thread.sleep(333);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        };
        child.start();
 
        // run a util thread
        Thread thread = new Thread() {
            public void run() {
                byte[] buffer = new byte[10];
                int count;
                try {
                    do {
                        while ((count = System.in.read(buffer)) == -1)
                            ;
                    } while (!System.lineSeparator().equals(
                            new String(buffer, 0, count)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("ENTER has been obtained");
                System.out.println("Notify a child thread to terminate");
                child.interrupt();
            }
        };
        thread.start();
        return thread;
    }
 
    // terminates an execution when a line separator is passed
    public static void main(String[] args) throws Exception {
        main();
    }
}

 

 
Это старый вариант, он содержит ошибку!!!
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
 
class Test extends Thread {
     
    public void run() {
        while (true) {
            try {
                System.out.println("Demon works");
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }       
    }
     
    public static void main(String[] args) throws Exception {
        Test t = new Test();
        t.setDaemon(true);
        t.start();
         
        new Thread() {
            public void run() {
                byte[] buffer = new byte[10];
                int count;
                try {
                    do {
                        while ((count = System.in.read(buffer)) == -1);
                    } while (!System.lineSeparator().equals(new String(buffer, 0, count)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("ENTER has been obtained");                
            }
        }.start();
    }
}
 
public class Main {
     
    public static void main(String[] args) throws Exception {
        // save standard input
        InputStream stdIn = System.in;
 
        // create input stream with line terminator (=ENTER)
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
 
        // move internal pointer of input stream to the end of input
        bais.skip(System.lineSeparator().length()); 
 
        // assign new value of standard input   
        System.setIn(bais);
         
        // main functionality
        Test.main(args);
 
        // waith for 3 sec
        Thread.sleep(3000);
 
        System.out.println("Try to send enter to standard input");
 
        // move internal pointer to begin of input
        bais.reset();
 
        // restore standard input
        System.setIn(stdIn);
    }
     
}

</pre>
