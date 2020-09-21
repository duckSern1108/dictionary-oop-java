import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public DictionaryManagement() {

    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        int count;
        System.out.println("So tu:");
        count = scanner.nextInt();
        scanner.nextLine();
        Word tempW = new Word();
        String temp;
        int i;
        for (i = 0; i < count; i++) {
            temp = scanner.nextLine();
            temp.setWord_target(temp);
            temp = scanner.nextLine();
            temp.setWord_explain(temp);
            dictionary.addWord(tempW);
        }
    }

    public Dictionary out() {
        return dictionary;
    }

}
