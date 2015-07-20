
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class Classifier {


    private HashMap<Integer, Word> words;


    public Classifier() {

        words = new HashMap<>();

    }

    public void processMail(Mail mail){

        for(Integer key: mail.getMap().keySet()){

            //si ya tiene la palabra se modifica
            if(words.containsKey(key)){


                words.get(key).updateCount(mail.getIsSpam(),mail.getMap().get(key));



            } else {


                //poner una palabra nueva en el diccionario
                //       donde           spam?         cuantas veces sale en el mail
                words.put(key, new Word(mail.getIsSpam(), mail.getMap().get(key)));


            }


        }


    }

    public HashMap<Integer, Word> getWords() {
        return words;
    }
}