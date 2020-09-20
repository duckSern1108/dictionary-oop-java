import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public DictionaryManagement() {

    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int count;
        System.out.println("So tu:");
        count = sc.nextInt();
        sc.nextLine();
        Word tempW = new Word();
        String temp;
        int i;
        for (i = 0; i < count; i++) {
            temp = sc.nextLine();
            temp.setWord_target(temp);
            temp = sc.nextLine();
            temp.setWord_explain(temp);
            dictionary.addWord(tempW);
        }
    }

    public Dictionary out() {
        return dictionary;
    }

}
