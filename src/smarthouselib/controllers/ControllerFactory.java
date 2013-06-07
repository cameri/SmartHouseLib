package smarthouselib.controllers;

import smarthouselib.controllers.drivers.MochadDriver;

/**
 * @author cameri
 * @since 6/6/13
 */
public class ControllerFactory
{

  public IController CreateX10ControllerWithMochad(String address, int port)
  {
    MochadDriver driver = MochadDriver.getInstance();
    driver.setAddress(address);
    driver.setPort(port);

    X10Controller controller = new X10Controller();
    controller.initialize(driver);

    return controller;
  }

}
