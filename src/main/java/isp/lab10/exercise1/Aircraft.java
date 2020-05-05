package isp.lab10.exercise1;

public class Aircraft implements Runnable {

    private String id;
    private int altitude;

    public Aircraft(String id,int altitude){
      this.id=id;
      this.altitude=altitude;
    }

    public void receiveAtcMessage(AtcCommand msg){

    }
    @Override
    public void run() {

    }
}
