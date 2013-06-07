package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author cameri
 * @since 6/6/13
 */
public class X10DimmableLampDriver implements IDeviceDriver, IDimmableDriver
{

  IController controller;
  DeviceDriverState currentState = DeviceDriverState.Uninitialized;

  @Override
  public void initialize(IController controller)
  {
    this.controller = controller;

    this.currentState = DeviceDriverState.Initialized;
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
  public void setBrightness(int brightness)
  {

  }

  @Override
  public int getBrightness() throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }

  @Override
  public void decreaseBrightness(int amount)
  {

  }

  @Override
  public void increaseBrightness(int amount)
  {

  }


  @Override
  public String toString()
  {
    return "X10DimmableLampDriver{" +
      "currentState=" + currentState +
      '}';
  }
}
