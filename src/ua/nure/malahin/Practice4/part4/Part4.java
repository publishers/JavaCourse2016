package ua.nure.malahin.Practice4.part4;

import ua.nure.malahin.Practice4.Util;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 01.06.16.
 */
public class Part4 implements  Iterable<String>{
    private String sentences;

    public Part4(String sentences){
        this.sentences = sentences;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    private final class IteratorImpl implements Iterator<String>{
	private Pattern pat;
        private Matcher m ;

        private IteratorImpl() {
            pat = Pattern.compile("(\\w)(.|(\\n|\\r|\\t|))+?\\.");
            m = pat.matcher(sentences);
        }

        public boolean hasNext() {
            return m.find();
        }

        public String next() {
            return m.group();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public static void main(String[] args) {
        String sentences = Util.getInput("part4.txt");
        Part4 p4 = new Part4(sentences);
        Iterator<String> iter = p4.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
