package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;
import smarthouselib.geo.Zone;

/**
 * @author Ricardo A Cabral
 * @since 6/6/13
 */
public interface IDevice
{

  void initialize();

  void setID(String ID);

  String getID();

  void setState(DeviceState newState);

  DeviceState getState();

  DeviceCapabilities[] getCapabilities();

  IDeviceDriver getDriver();

  void setDriver(IDeviceDriver driver);

  Zone getZone();

  void setZone(Zone zone);
}
