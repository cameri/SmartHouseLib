package smarthouse.devices;

import smarthouse.DeviceCapabilities;
import smarthouse.DeviceState;
import smarthouse.IDevice;
import smarthouse.IToggleable;
import smarthouse.drivers.IToggleableDriver;

/**
  *
  * @author Ricardo A Cabral
  */
public class Lamp implements IDevice,IToggleable {
  String ID;
  DeviceState currentState = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[] { DeviceCapabilities.Toggleable };
  IToggleableDriver driver;

  @Override
  public void setID(String ID) {
      this.ID = ID;
  }

  @Override
  public String getID() {
      return this.ID;
  }

  @Override
  public void setCurrentState(DeviceState newState) {
      this.currentState = newState;
  }

  @Override
  public DeviceState getCurrentState() {
      return currentState;
  }

  @Override
  public DeviceCapabilities[] getCapabilities() {
  return this.capabilities;
  }

  @Override
  public void turnOn() {
      if (this.driver != null)
      {
          this.driver.turnOn();
          this.currentState = DeviceState.On;
      }
  }

  @Override
  public void turnOff() {
      if (this.driver != null)
      {
          this.driver.turnOff();
          this.currentState = DeviceState.Off;
      }
  }

  @Override
  public void toggle()
  {
    if (this.currentState == DeviceState.Off)
    {
      this.turnOn();

    } else {
      this.turnOff();
    }
  }

  @Override
  public void setDriver(IToggleableDriver newDriver) {
      this.driver = newDriver;
  }

  @Override
  public IToggleableDriver getDriver() {
      return this.driver;
  }

}
