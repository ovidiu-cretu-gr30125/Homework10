package isp.lab10.exercise1;

public class Aircraft implements Runnable {

    private String id;
    private int altitude;

    public Aircraft(String id){
      this.id=id;
      this.altitude=0;
    }
     public String getId(){
        return id;
     }

    public void receiveAtcMessage(AtcCommand msg){
            if(msg instanceof TakeoffCommand){
                this.altitude=((TakeoffCommand) msg).getAltitude();
                synchronized (this){
                this.notify();
                }
            }
            else {
                if(msg instanceof LandCommand){
                    synchronized (this) {
                        this.notify();
                    }
                }
            }
    }
    @Override
    public void run() {
        boolean status = true;
        String aircraftStatus="ON STAND";
        System.out.println("on stand..."+this.getId()+"");
        while (status) {
            switch (aircraftStatus) {
                case "ON STAND": {
                    try {
                        synchronized (this) {
                            System.out.println("wait "+this.getId()+"");
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("taxing "+this.getId()+"");
                    aircraftStatus= "TAXING";
                }
                break;
                case "TAXING": {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("taking off");
                    aircraftStatus="TAKING OFF";
                }
                break;
                case "TAKING OFF":{
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ascending");
                    aircraftStatus="ASCENDING";
                }
                break;
                case "ASCENDING":{
                    try {
                        Thread.sleep((altitude*10000)/1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("cruising");
                    aircraftStatus="CRUISING";
                }
                break;
                case "CRUISING":{
                    try {
                        synchronized (this) {
                           this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("descending");
                    aircraftStatus="DESCENDING";
                }
                break;
                case "DESCENDING":{
                    try {
                        Thread.sleep((altitude*10000)/1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("landed");
                    aircraftStatus="LANDED";
                }
                break;
                case "LANDED":{
                    System.out.println("stop");
                    status=false;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", altitude=" + altitude +
                '}';
    }
}
