package isp.lab10.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ATC {

    List<Aircraft> aircraftList = new ArrayList<>();

    /**
     * this method add the aircraft object to the aircraft list
     * @param aircraft the object added to the list
     * @throws InterruptedException
     */
    synchronized void addAircraft(Aircraft aircraft) throws InterruptedException {
        aircraftList.add(aircraft);
    }

    /**
     * this method send the command to the aircraft
     * @param aircraftId the id of the aircraft that has to be commanded
     * @param cmd the type of class for command (TakeoffCommand or LandCommand)
     */
    public void sendCommand(String aircraftId,AtcCommand cmd){
            for(Aircraft aircraft : aircraftList){
                if(aircraft.getId().equals(aircraftId)){
                   aircraft.receiveAtcMessage(cmd);
                }
            }
    }

    /**
     * this method return the aircraft from the list
     * @return aircraft
     */
    public List<Aircraft> showAircraft() {
        return aircraftList;
    }
}
