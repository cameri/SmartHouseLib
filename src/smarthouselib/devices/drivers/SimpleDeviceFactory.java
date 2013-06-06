/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouselib.devices.drivers;

import smarthouselib.devices.Lamp;

/**
 * @author Ricardo A Cabral
 */
public class SimpleDeviceFactory
{

  public static Lamp CreateWorldTechLamp(String ID)
  {
    Lamp newLamp = new Lamp();
    newLamp.setID(ID);
    return newLamp;
  }

}
