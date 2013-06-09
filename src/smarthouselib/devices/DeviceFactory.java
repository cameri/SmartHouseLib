/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouselib.devices;

import smarthouselib.devices.drivers.IUPSDriver;
import smarthouselib.devices.drivers.UPSDriverFactory;

/**
 * @author Ricardo A Cabral
 */
public class DeviceFactory
{

  public static UPS CreateAPCUPS(String address, int port)
  {
    IUPSDriver driver = UPSDriverFactory.CreateAPCUPSDriver(address, port);
    UPS ups = new UPS();
    ups.setDriver(driver);

    return ups;
  }
}
