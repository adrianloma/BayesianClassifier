public class Word {


    private int timesInSpam;
    private int timesInLegit;



    public Word(Boolean spam, int count) {
        if(spam){
            timesInSpam = count;
            timesInLegit = 0;
        } else {
            timesInSpam = 0;
            timesInLegit = count;
        }
    }

    public void updateCount(Boolean spam, int count){

        if(spam)
            timesInSpam += count;
        else
            timesInLegit += count;


    }



    public int getTimesInSpam() {
        return timesInSpam;
    }

    public int getTimesInLegit() {
        return timesInLegit;
    }
}