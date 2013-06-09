package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.geo.Zone;

/**
 * @author cameri
 * @since 6/7/13
 */
public abstract class Device implements IDevice
{

  int Id;
  DeviceState state = DeviceState.Unknown;
  DeviceCapabilities capabilities[] = new DeviceCapabilities[]{};
  IDeviceDriver driver;
  Zone zone;
  int zone_id;
  String address;

  @Override
  public void setId(int Id)
  {
    this.Id = Id;
  }

  @Override
  public int getId()
  {
    return this.Id;
  }

  @Override
  public void setAddress(String Id)
  {
    this.address = Id;
  }

  @Override
  public String getAddress()
  {
    return this.address;
  }

  @Override
  public void setState(DeviceState newState)
  {
    this.state = newState;
  }

  @Override
  public DeviceState getState()
  {
    return state;
  }

  @Override
  public DeviceCapabilities[] getCapabilities()
  {
    return this.capabilities;
  }

  @Override
  public void setCapabilities(DeviceCapabilities[] capabilities)
  {
    this.capabilities = capabilities;
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
