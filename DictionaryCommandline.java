public class DictionaryCommandline {
    private Dictionary dictionary;
    private DictionaryManagement dic;

    public DictionaryCommandline() {

    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void showAllWords() {
        int i;
        System.out.println("No\tEnglish\tVietnamese");
        for(i = 0; i < dictionary.getNo(); i ++) {
            System.out.println((i + 1) +dictionary.getIndividualWords_target(i) +
                    dictionary.getIndividualWords_explain(i));
        }
    }

    public void dictionaryBasic() {
        dic = new DictionaryManagement(dictionary);
        dic.setDictionary(dictionary);
        dic.insertFromCommandline();
        this.dictionary = dic.out();
        showAllWords();
    }
}

