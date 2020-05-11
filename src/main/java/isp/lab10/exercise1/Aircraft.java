package isp.lab10.exercise1;

import javax.swing.*;


public class Aircraft implements Runnable{

    private String id;
    private int altitude;
    private String aircraftStatus="ON STAND";
    private boolean status=true;
    private JTextField textField = new JTextField();

    public Aircraft(String id){
      this.id=id;
      this.altitude=0;
    }
     public String getId(){
        return id;
     }

    /**
     * this method get the command from ATC class and apply it to the aricraft
     * @param msg the command for the aircraft
     */
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

    /**
     * this is the method for the road of the aircraft
     * after adding it to the list ths status is "ON STAND" and the aircraft has to wait (using wait() method for the thread)
     * after receiving the takeoff command the status is set to "TAXING" where it stays for 10 sec (using sleep() method for thread )
     * after taxing the aircraft is preparing for taking off (5 sec) setting the status to "TAKING OFF" (using sleep() method for thread)
     * after taking off, the aircraft is ascending for 10 sec at about 1000 meters, on "ASCENDING" status (using sleep for thread)
     * after ascending, the aircraft is in "CRUISING" mode while it si no receiving the land command (using wait())
     * after receiving the land command, tha aircraft's status is now on "DESCENDING" for 10 sec at about 1000 meters (using sleep())
     * the aircraft is completely  landed after the altitude is 0 and the status is on "LANDED" (stopping the while)
     */
    @Override
    public void run() {
        long startTime=0,endTime=0,cruisingTime=0;
        while (status) {
            switch (aircraftStatus) {
                case "ON STAND": {
                    try {
                        synchronized (this) {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aircraftStatus= "TAXING";
                }
                break;
                case "TAXING": {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aircraftStatus="TAKING OFF";
                }
                break;
                case "TAKING OFF":{
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aircraftStatus="ASCENDING";
                }
                break;
                case "ASCENDING":{
                    try {
                        Thread.sleep((altitude*10000)/1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aircraftStatus="CRUISING";
                }
                break;
                case "CRUISING":{
                    try {
                        synchronized (this) {
                            startTime = System.nanoTime();
                           this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    endTime = System.nanoTime();
                    cruisingTime  = endTime-startTime;
                    System.out.println("Cruising time for aircraft "+this.getId()+""+ cruisingTime);
                    aircraftStatus="DESCENDING";
                }
                break;
                case "DESCENDING":{
                    try {
                        Thread.sleep((altitude*10000)/1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aircraftStatus="LANDED";
                }
                break;
                case "LANDED":{
                    status=false;
                }
            }
        }
    }
    public boolean getAircraftStatus(){
        return status;
    }
    public String showStatus(){
            return aircraftStatus;
    }
    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", altitude=" + altitude +
                "}\n";
    }
}
