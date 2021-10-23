package dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
    public static List<Word> dictionary = new ArrayList<>();

    public void insertFromCommandLine() {
        int NumWord;
        Scanner input = new Scanner(System.in);
        NumWord = input.nextInt();

        for (int i = 0; i < NumWord; i++) {
            String WoTa = input.nextLine();
            String WoEx = input.nextLine();
            Word word = new Word(WoTa, WoEx);
            dictionary.add(word);
        }
    }

    public List<Word> insertFromFile() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("./src/dictionary/dictionaries.txt"));
            String lineJustFetched;
            String[] wordsArray;

            while (true) {
                lineJustFetched = buf.readLine();
                if (lineJustFetched == null) {
                    break;
                } else {
                    wordsArray = lineJustFetched.split("\t");
                    Word word = new Word(wordsArray[0], wordsArray[1]);
                    dictionary.add(word);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dictionary;

    }

    public void dictionaryLookup(String wordtarget,List<Word>dictionary) {
        for (Word word : dictionary)
            if (word.getWord_target().equals(wordtarget)) {
                System.out.println(word.getWord_target());
            }
    }
    public List<Word> currentWordLookup(String word,List<Word>dictionary) {
        ArrayList<Word> current = new ArrayList<>();

        for (Word value : dictionary) {
            if (value.getWord_target().startsWith(word)) {
                current.add(value);
            }
        }

        return current;
    }
    public static void dictionaryExportToFile(List<Word> dictionary, String file) {
        try {
            File fout = new File("./src/dictionary/" + file + ".txt");
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (Word i : dictionary) {
                bw.write(i.getWord_target() + "\t" + i.getWord_explain());
                bw.newLine();
            }

            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException var7) {
            System.out.println("An error occurred.");
            var7.printStackTrace();
        }
    }

    public static void deleteWords(List<Word> dictionary, String english) {
        dictionary.removeIf((n) -> n.getWord_target().equals(english));
    }
public  void updateWords(List<Word>dictionary,Word word){
    for (Word value : dictionary)
        if (value.getWord_target().equals(word.getWord_target())) {
            value.setWord_target(word.getWord_target());
            value.setWord_explain(word.getWord_explain());
        }
}




}

