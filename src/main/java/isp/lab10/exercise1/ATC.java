package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ATC {

    List<Aircraft> aircraftList = new ArrayList<>();

    synchronized void addAircraft(String id) throws InterruptedException {
        Aircraft aircraft = new Aircraft(id);
        aircraftList.add(aircraft);
        Thread thread = new Thread(aircraft);
        thread.start();
    }

    public void sendCommand(String aircraftId,AtcCommand cmd){
            for(Aircraft aircraft : aircraftList){
                if(aircraft.getId().equals(aircraftId)){
                   aircraft.receiveAtcMessage(cmd);
                }
            }
    }

    public String showAircraft(){
        for(Aircraft aircraft : aircraftList){
            return aircraft.toString();
        }
        return null;
    }
}
