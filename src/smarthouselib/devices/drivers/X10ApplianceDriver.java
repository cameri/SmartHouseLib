package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author cameri
 * @since 6/10/13
 */
public class X10ApplianceDriver implements IDeviceDriver, IToggleableDriver
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
    System.out.println("Turning appliance on.");
  }

  @Override
  public void turnOff()
  {
    System.out.println("Turning appliance off.");
  }

  @Override
  public String toString()
  {
    return "X10ApplianceDriver{" +
      "currentState=" + currentState +
      '}';
  }
}
