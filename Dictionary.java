public class Dictionary {
    private Word[] words = new Word[100];
    private int no = 0;

    public Dictionary() {

    }

    public int getNo() {
        return no;
    }

    public String getIndividualWords_explain(int i) {
        return words[i].getWord_explain();
    }

    public String getIndividualWords_target(int i) {
        return words[i].getWord_target();
    }

    public void addWord(Word word) {
        words[no] = new Word(word);
        no++;
    }

    public Dictionary(Dictionary dictionary) {
        this.words = dictionary.getWords();
        this.no = dictionary.no();
    }


    public Word[] getWords() {
        return words;
    }
}