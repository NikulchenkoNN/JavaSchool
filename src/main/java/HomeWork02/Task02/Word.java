package HomeWork02.Task02;

public class Word implements Comparable<Word>{
    private String word;


    public Word(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Word word) {
        return this.word.length() - word.word.length();
    }

    @Override
    public String toString() {
        return word;


    public Word(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Word word) {
        return this.word.length() - word.word.length();

    }

}
