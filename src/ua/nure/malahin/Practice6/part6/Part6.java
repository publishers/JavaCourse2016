package ua.nure.malahin.Practice6.part6;

import ua.nure.malahin.Practice6.part1.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergey on 15.06.16.
 */
public class Part6 {

    private static String spliterator = "\\w+(|'|%)";
    private static Pattern pat = Pattern.compile(spliterator);

    private static final String ENCODING = "utf8";
    private static final String EOL = "\n";

    public static String getInput(String fileName) {
	StringBuilder sb = new StringBuilder();
	try {
	    if (fileName.equals("")) {
		throw new IOException();
	    }
	    Scanner scanner = new Scanner(new File(fileName), ENCODING);

	    while (scanner.hasNextLine()) {
		sb.append(scanner.nextLine()).append(EOL);
	    }
	    scanner.close();
	} catch (IOException ex) {
	    System.out.println(ex);
	    return null;
	}
	return sb.toString().trim();

    }

    private static WordContainer wc;

    public static void part1(String string) {
	wc = new WordContainer() {
	    @Override
	    public String toString() {
		StringBuilder sb = new StringBuilder();
		getSBWordsByFrequency(sb, getWords());
		return sb.toString();
	    }

	    public void sort() {
		sortPart1(getWords());
	    }

	};
	fillWordContainer(wc, string);
	wc.sort();
	System.out.println(wc);
    }
    
    private static StringBuilder getSBWordsByFrequency(StringBuilder sb, List<Word> words){
	int i = 0;
	for (Word word : words) {
	    if (i == 3) {
		break;
	    }
	    sb.append(word.getWord()).append(" ==> ").append(word.getFrequency())
		    .append(System.lineSeparator());
	    i++;
	}
	return sb;
    }
    
    private static StringBuilder getSBWordsByLength(StringBuilder sb, List<Word> words){
   	int i = 0;
   	for (Word word : words) {
   	    if (i == 3) {
   		break;
   	    }
   	    sb.append(word.getWord()).append(" ==> ").append(word.getWord().length())
   		    .append(System.lineSeparator());
   	    i++;
   	}
   	return sb;
       }
    
   

    private static void sortPart1(List<Word> s) {
	Collections.sort(s, new Comparator<Word>() {
	    @Override
	    public int compare(Word w1, Word w2) {
		int freq1 = w1.getFrequency();
		int freq2 = w2.getFrequency();
		return freq2 - freq1;
	    }
	});
	Collections.sort(s.subList(0, 3), new Comparator<Word>() {
	    @Override
	    public int compare(Word o1, Word o2) {
		return o2.getWord().compareTo(o1.getWord());
	    }
	});

    }

    public static void part2(String string) {
	wc = new WordContainer() {
	    @Override
	    public String toString() {
		StringBuilder sb = new StringBuilder();
		getSBWordsByLength(sb, getWords());
		return sb.toString();
	    }

	    public void sort() {
		sortPart2(getWords());
	    }
	};

	fillWordContainer(wc, string);
	wc.sort();
	System.out.println(wc);
    }
    
    private static void sortPart2(List<Word> s) {
	Collections.sort(s, new Comparator<Word>() {
	    @Override
	    public int compare(Word o1, Word o2) {
		int len1 = o1.getWord().length();
		int len2 = o2.getWord().length();
		return len2 - len1;
	    }
	});

    }


    public static void part3(String string) {
	wc = new WordContainer() {
	    @Override
	    public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Word word : getWords()) {
		    if (i == 3) {
			break;
		    }
		    if (word.getFrequency() >= 2) {
			sb.append(word.getWord().toUpperCase()).append(System.lineSeparator());
			i++;
		    }
		}
		return sb.toString();
	    }
	};
	fillWordContainer(wc, string);
	System.out.println(wc);

    }

    private static void fillWordContainer(WordContainer wc, String fileName) {
	Matcher mat = pat.matcher(getInput(fileName));
	while (mat.find()) {
	    wc.add(mat.group());
	}
    }

    private static boolean isCorrectInput(String s) {
	return (s.equals("-i") || s.equals("-input"));
    }

    private static boolean isCorrectTask(String s) {
	return (s.equals("-t") || s.equals("-task"));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

	System.setIn(new ByteArrayInputStream(
		"-i text.txt -t frequency\n-i text.txt -t length\n-i text.txt -t duplicates".getBytes("cp1251")));

	Scanner scanner = new Scanner(System.in, ENCODING);
	while (scanner.hasNextLine()) {
	    String[] strings = scanner.nextLine().split(" ");
	    if (strings.length == 4) {
		if (isCorrectInput(strings[0]) && isCorrectTask(strings[2])) {

		    if (strings[3].equals("frequency")) {
			part1(strings[1]);
		    } else if (strings[3].equals("length")) {
			part2(strings[1]);
		    } else if (strings[3].equals("duplicates")) {
			part3(strings[1]);
		    }

		}
	    } else {
		System.out.println("Wrong query!!!");
	    }
	}
	scanner.close();
    }
}
