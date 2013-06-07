package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.devices.drivers.IToggleableDriver;

/**
 * @author Nelson Rosario
 */
public class Appliance implements IDevice, IToggleable
{

  String ID;
  DeviceState currentState = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[]{DeviceCapabilities.Toggleable};
  IDeviceDriver driver;

  @Override
  public void initialize(IDeviceDriver driver)
  {
    this.driver = driver;
  }

  @Override
  public void setID(String ID)
  {
    this.ID = ID;
  }

  @Override
  public String getID()
  {
    return this.ID;
  }

  @Override
  public void setState(DeviceState newState)
  {
    this.currentState = newState;
  }

  @Override
  public DeviceState getState()
  {
    return currentState;
  }

  @Override
  public DeviceCapabilities[] getCapabilities()
  {
    return this.capabilities;
  }

  @Override
  public void turnOn()
  {
    IDeviceDriver _driver = this.getDriver();
    if (_driver instanceof IToggleableDriver)
    {
      ((IToggleableDriver) _driver).turnOn();
      this.setState(DeviceState.On);
    }
  }

  @Override
  public void turnOff()
  {
    IDeviceDriver _driver = this.getDriver();
    if (_driver instanceof IToggleableDriver)
    {
      ((IToggleableDriver) _driver).turnOff();
      this.setState(DeviceState.Off);
    }
  }

  @Override
  public void toggle()
  {
    if (this.getState() == DeviceState.Off)
    {
      this.turnOn();
    } else
    {
      this.turnOff();
    }
  }

  @Override
  public IDeviceDriver getDriver()
  {
    return this.driver;
  }

  @Override
  public IToggleableDriver getToggleableDriver()
  {
    if (this.driver instanceof IToggleableDriver)
    {
      return (IToggleableDriver) this.driver;
    }
    return null;
  }

  @Override
  public String toString()
  {
    return String.format("Appliance (%s)", this.getID());
  }
}
