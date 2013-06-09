package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.geo.Zone;

/**
 * @author Ricardo A Cabral
 * @since 6/6/13
 */
public interface IDevice
{

  void setId(int Id);

  int getId();

  void setAddress(String address);

  String getAddress();

  void setState(DeviceState newState);

  DeviceState getState();

  DeviceCapabilities[] getCapabilities();

  void setCapabilities(DeviceCapabilities[] capabilities);

  IDeviceDriver getDriver();

  void setDriver(IDeviceDriver driver);

  Zone getZone();

  void setZone(Zone zone);
}
