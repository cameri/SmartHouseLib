package smarthouselib.devices;

import smarthouselib.devices.drivers.IUPSDriver;
import smarthouselib.geo.Zone;

/**
 * @author cameri
 * @since 6/9/13
 */
public interface IUPS
{
  IUPSDriver getDriver();

  void setDriver(IUPSDriver driver);

  String getStatus();

  String getModel();

  Zone getZone();

  void setZone(Zone zone);

  float getBatteryCharge();

  float getTimeLeftInMinutes();

  float getBatteryVoltage();

  float getLineVoltage();
}
