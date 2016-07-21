package ua.nure.malahin.Practice6.part1;

/**
 * Created by sergey on 15.06.16.
 */
public class Word implements Comparable<Word>{
    private String word;
    private int frequency;
    private int hash;
    private char[] value;

    public Word(String word){
        if(checkWord(word)){
            throw new IllegalArgumentException();
        }
        value = word.toCharArray();
        this.word = word;
        frequency = 1;

    }

    private boolean checkWord(String word) {
        return (word.contains(",") || word.contains("!") || word.contains(".") || word.contains("?"));
    }

    public void incrementFrequency(){
        frequency++;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getHash() {
        return hash;
    }

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

    @Override
    public boolean equals(Object anObject) {
	if(anObject == null) {
	    return false;
	}
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Word){        
            Word anotherString = (Word)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i]){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Word anotherString) {
            int freq1 = frequency;
            int freq2 = anotherString.frequency;

        if(freq2 == freq1){
            int len1 = value.length;
            int len2 = anotherString.value.length;
            int lim = Math.min(len1, len2);
            char v1[] = value;
            char v2[] = anotherString.value;
            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
        }

        return freq2 - freq1;
    }

    @Override
    public String toString() {
        return word + ":" + frequency;
    }
}
