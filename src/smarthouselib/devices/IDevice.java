package smarthouselib.devices;

import smarthouselib.devices.drivers.IDeviceDriver;

/**
 * @author Ricardo A Cabral
 * @since 6/6/13
 */
public interface IDevice
{

  void initialize(IDeviceDriver driver);

  void setID(String ID);

  String getID();

  void setState(DeviceState newState);

  DeviceState getState();

  DeviceCapabilities[] getCapabilities();

  IDeviceDriver getDriver();
}
