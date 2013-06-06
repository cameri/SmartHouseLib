/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouselib.drivers;

import smarthouselib.devices.Lamp;

/**
 *
 * @author Ricardo A Cabral
 */
public class SimpleDeviceFactory {
  
    public static Lamp CreateWorldTechLamp(String ID)
    {
        Lamp newLamp = new Lamp();
        newLamp.setID(ID);
        newLamp.setDriver(new WorldTechLampDriver());
        return newLamp;
    }
    
    public static Lamp CreateArturoLamp(String ID)
    {
        Lamp newLamp = new Lamp();
        newLamp.setID(ID);
        newLamp.setDriver(new ArturoLampDriver());
        return newLamp;
    }
}
