package dictionary;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button speak;
    @FXML
    TextField search;
    @FXML
    TextArea meaning;
    @FXML
    Button add;
    @FXML
    Button delete;
    @FXML
    Button update;
    @FXML
    ListView<String> recommend;
    List<Word>dictionary= new ArrayList<>();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    List<Word> Listcurrent = new ArrayList<>();

    @FXML
    public void searchWord() {
        String s = search.getText();
        recommend.getItems().clear();
        if (s.equals("")) {
            meaning.setText("");
        } else {
            Listcurrent = dictionaryManagement.currentWordLookup(s,dictionary);
            for (Word word : Listcurrent) {
                recommend.getItems().add(word.getWord_target());
            }
            String a=Listcurrent.get(0).getWord_explain();
            String s1=a.replace("*/","\n");
            String s2=s1.replaceAll("-","\n");
            meaning.setText(s2);
        }
    }

    @FXML
    public void add() {
        String word_taget = this.search.getText();
        String word_explain = this.meaning.getText();
        Word word = new Word(word_taget, word_explain);
        dictionary.add(word);
        DictionaryManagement.dictionaryExportToFile(dictionary,"dictionaries");
    }

    public void delete() {
        String s = this.search.getText();
        DictionaryManagement.deleteWords(dictionary, s);
        DictionaryManagement.dictionaryExportToFile(dictionary,"dictionaries");
    }

    public void update() {
        Word word=new Word(this.search.getText(),this.meaning.getText());
        dictionaryManagement.updateWords(dictionary,word);

    }
    public void speaking() {
        Speak Speak = new Speak("kevin16");
        Speak.say(search.getText());
    }

    public void click(){
        int index=recommend.getSelectionModel().getSelectedIndex();
        search.setText(Listcurrent.get(index).getWord_target());
        String a=Listcurrent.get(index).getWord_explain();
        String s1=a.replace("/*","\n");
        String s2=s1.replaceAll("-","\n");
        meaning.setText(s2);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dictionary=dictionaryManagement.insertFromFile();
    }

}
