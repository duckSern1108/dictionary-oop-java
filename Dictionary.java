public class Dictionary {
    private Word[] words = new Word[100];
    private int length;

    public Dictionary() {

    }

    public int getLength() {
        return length;
    }

    public String getIndividualWords_explain(int i) {
        return words[i].getWord_explain();
    }

    public String getIndividualWords_target(int i) {
        return words[i].getWord_target();
    }

    public void addWord(Word word) {
        words[length] = new Word(word);
        length += 1;
    }

    public Dictionary(Dictionary dictionary) {
        this.words = dictionary.getWords();
        this.length = dictionary.getLength;
    }


    public Word[] getWords() {
        return words;
    }
}
