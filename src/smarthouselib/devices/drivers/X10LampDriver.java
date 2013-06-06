package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author Ricardo A Cabral
 */
public class X10LampDriver implements IDeviceDriver, IToggleableDriver
{

  IController controller;

  @Override
  public void initialize(IController controller)
  {
    this.controller = controller;
  }

  @Override
  public void turnOn()
  {
    System.out.println("Turning lamp on.");
  }

  @Override
  public void turnOff()
  {
    System.out.println("Turning lamp off.");
  }

}
