package dictionary;

import java.util.List;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement=new DictionaryManagement();
    static Dictionary dict;

    public static void showAllWords(List<Word> dictionary){
        System.out.print("No\t| English\t| Vietnamese");
        for(int i = 0; i < dictionary.size(); i++){
            System.out.print(i + " \t| " + dict.wordList.get(i).getWord_target() +
                    "\t| " + dict.wordList.get(i).getWord_explain());
        }
    }
}
