import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {



        List<Mail> startingSet = new ArrayList<>();
        List<Mail> validationSet;
        List<Mail> trainingSet;

        String target_dir = "bayes";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();


        if (files != null) {
            for(File f:files){

                if (f.isFile()){

                    BufferedReader inputStream = null;

                    try{
                        inputStream = new BufferedReader(new FileReader(f));
                        String subject, body;

                        subject = inputStream.readLine();
                        subject = subject.substring(9);
                        inputStream.readLine();
                        body = inputStream.readLine();

                        System.out.println(subject);

                        startingSet.add(new Mail(subject,body, f.getName().contains("spmsg")));


                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }



                }


            }
        }


        Collections.shuffle(startingSet);

        trainingSet = startingSet.subList(startingSet.size()/5, startingSet.size());
        validationSet = startingSet.subList(0,startingSet.size()/5);


        Classifier classifier = new Classifier();

        for (Mail mail:trainingSet){
            classifier.processMail(mail);

        }


        classifier.finishTraining();

        int countSpam = 0;
        int countLegit = 0;
        int countTotal;
        for (Word word : classifier.getWords().values()){
            countLegit += word.getTimesInLegit();
            countSpam += word.getTimesInSpam();
        }
        countTotal = countLegit + countSpam;

        double pSpam = (double) countSpam/ (double) countTotal;
        double pLegit = (double) countLegit/ (double) countTotal;

        classifier.evaluate(mail);

    }
}