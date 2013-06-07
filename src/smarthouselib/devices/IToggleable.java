package smarthouselib.devices;

import smarthouselib.devices.drivers.IToggleableDriver;

/**
 * @author cameri
 * @since 6/5/13
 */
public interface IToggleable
{

  void turnOn();

  void turnOff();

  void toggle();

  IToggleableDriver getToggleableDriver();
}
