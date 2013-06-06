package smarthouselib.devices.drivers;

import smarthouselib.controllers.IController;

/**
 * @author cameri
 * @since 6/6/13
 */
public interface IDeviceDriver
{

  void initialize(IController controller);

}
