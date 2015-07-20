
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Mail {


    private Boolean isSpam;

    private HashMap<Integer, Integer> map;


    public Mail(String subject, String body, Boolean spam) {

        map = new HashMap<>();

        this.isSpam = spam;
        readMail(subject,body);

    }


    private void readMail(String subject, String body){


        //se agarran todas las "palabras" del mail
        String[] items = (subject + " " + body).split(" ");

        //recorre todas las palabras del mail
        for (String item : items) {

            //se convierte a int la palabra
            int number = Integer.parseInt(item);

            //si no existe en el hashmap
            if(!map.containsKey(number)){

//                //crea palabra para meter a hashmap
//                Word word = new Word(number);
//
//                //se agrega una a spam o no dependiendo del mail
//                word.updateCount(isSpam, 1);

                //se agrega al hashmap
                map.put(number, 1);


            } else {
//
//                //si ya existe se modifica la cantidad
//                map.get(number).updateCount(isSpam, 1);

                map.put(number, map.get(number) + 1);

            }

        }

    }

    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    public Boolean getIsSpam() {
        return isSpam;
    }
}