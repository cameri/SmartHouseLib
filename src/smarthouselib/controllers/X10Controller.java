package smarthouselib.controllers;

import smarthouselib.controllers.drivers.IControllerDriver;

/**
 * @author cameri
 * @since 6/6/13
 */
public class X10Controller implements IController
{

  IControllerDriver controller_driver;


  @Override
  public void initialize(IControllerDriver driver)
  {
    this.controller_driver = driver;
  }
}
