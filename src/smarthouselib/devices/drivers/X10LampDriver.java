package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author Ricardo A Cabral
 */
public class X10LampDriver implements IDeviceDriver, IToggleableDriver
{

  IController controller;
  DeviceDriverState currentState = DeviceDriverState.Uninitialized;

  @Override
  public void initialize(IController controller)
  {
    this.controller = controller;

    // Set state as initialized
    currentState = DeviceDriverState.Initialized;
  }

  @Override
  public IController getController()
  {
    return this.controller;
  }

  @Override
  public DeviceDriverState getState()
  {
    return this.currentState;
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

  @Override
  public String toString()
  {
    return "X10LampDriver{" +
      "currentState=" + currentState +
      '}';
  }
}
