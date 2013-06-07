package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.geo.Zone;

/**
 * @author cameri
 * @since 6/7/13
 */
public abstract class Device implements IDevice
{

  String ID;
  DeviceState currentState = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[]{DeviceCapabilities.Toggleable};
  IDeviceDriver driver;
  Zone zone;

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
  public void setDriver(IDeviceDriver driver)
  {
    this.driver = driver;
  }

  @Override
  public IDeviceDriver getDriver()
  {
    return this.driver;
  }

  @Override
  public Zone getZone()
  {
    return this.zone;
  }

  @Override
  public void setZone(Zone zone)
  {
    this.zone = zone;
  }
}
