public class DictionaryCommandline {
    private Dictionary dictionary;
    private DictionaryManagement dicManage;

    public DictionaryCommandline() {

    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void showAllWords() {
        System.out.println("No\tEnglish\tVietnamese");
        for(int i = 0; i < dictionary.getLength(); i ++) {
            System.out.println((i + 1) +dictionary.getIndividualWords_target(i) +
                    dictionary.getIndividualWords_explain(i));
        }
    }

    public void dictionaryBasic() {
        dicManage = new DictionaryManagement(dictionary);
        dicManage.setDictionary(dictionary);
        dicManage.insertFromCommandline();
        this.dictionary = dicManage.out();
        showAllWords();
    }
}

