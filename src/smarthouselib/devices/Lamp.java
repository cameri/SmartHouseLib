package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.devices.drivers.IToggleableDriver;

/**
 * @author Ricardo A Cabral
 */
public class Lamp extends Device implements IToggleable
{

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
  public String toString()
  {
    return String.format("Lamp (%s)", this.getId());
  }
}
