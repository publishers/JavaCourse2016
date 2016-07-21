package ua.nure.malahin.Practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sergey on 15.06.16.
 */
public class WordContainer {
    private List<Word> words;

    public WordContainer(){
        this.words =  new ArrayList<>();
    }

    public void add(String s){
        boolean markAdd = true;
        for (Word word : words){
            if(s.equalsIgnoreCase(word.getWord())){
                word.incrementFrequency();
                markAdd = false;
            }
        }
        if (markAdd){
            words.add(new Word(s));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word:words){
            sb.append(word).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void sort(){
        Collections.sort(words);
    }

    public List<Word> getWords(){
        return words;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream("asd\nasdf\nasd\nasdf\nasdf\n43\nasdsf\n43\n43\n434".getBytes("cp1251")));
        Scanner in = new Scanner(System.in, "cp1251");
        WordContainer wc = new WordContainer();
        while (in.hasNextLine()) {
            wc.add(in.nextLine());
        }
        wc.sort();
        in.close();
        System.out.println(wc);
    }
}
