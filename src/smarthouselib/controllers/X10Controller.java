package smarthouselib.controllers;

import smarthouselib.controllers.drivers.IControllerDriver;
import smarthouselib.devices.DeviceTypes;
import smarthouselib.devices.IDevice;
import smarthouselib.devices.Lamp;
import smarthouselib.devices.drivers.X10LampDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cameri
 * @since 6/6/13
 */
public class X10Controller implements IController
{

  IControllerDriver controller_driver;
  Map<String, IDevice> deviceMap = new HashMap<String, IDevice>();

  @Override
  public void initialize(IControllerDriver driver)
  {
    this.controller_driver = driver;
  }

  @Override
  public IControllerDriver getDriver()
  {
    return this.controller_driver;
  }

  public IDevice newDevice(int id, String name, DeviceTypes deviceTypes)
  {
    if (deviceMap.containsKey(id))
      return null;

    return null;
  }

  public Lamp newLamp(int Id, String name)
  {


    Lamp newLamp = new Lamp();
    newLamp.setId(Id);

    // Get new driver
    X10LampDriver driver = new X10LampDriver();
    newLamp.setDriver(driver);

    return newLamp;
  }


  @Override
  public String toString()
  {
    return "X10Controller";
  }
}
