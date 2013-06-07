/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouselib.devices;

import smarthouselib.controllers.IController;
import smarthouselib.devices.drivers.DeviceDriverFactory;
import smarthouselib.devices.drivers.IDeviceDriver;

/**
 * @author Ricardo A Cabral
 */
public class DeviceFactory
{

  public static Lamp CreateX10Lamp(String ID, IController controller)
  {

    Lamp newLamp = new Lamp();
    newLamp.setID(ID);

    // Get new driver
    IDeviceDriver driver = DeviceDriverFactory.CreateX10LampDriver(controller);

    // Initialize device
    newLamp.initialize(driver);

    return newLamp;
  }

  public static DimmableLamp CreateX10DimmableLamp(String ID, IController controller)
  {
    DimmableLamp newLamp = new DimmableLamp();
    newLamp.setID(ID);

    // Get dimmable driver
    IDeviceDriver driver = DeviceDriverFactory.CreateX10DimmableLampDriver(controller);

    // Initialize device
    newLamp.initialize(driver);

    return newLamp;
  }

  public static Appliance CreateX10Appliance(String ID, IController controller)
  {
    Appliance newAppliance = new Appliance();
    newAppliance.setID(ID);

    // Get dimmable driver
    IDeviceDriver driver = DeviceDriverFactory.CreateX10DimmableLampDriver(controller);

    // Initialize device
    newAppliance.initialize(driver);

    return newAppliance;
  }


}
