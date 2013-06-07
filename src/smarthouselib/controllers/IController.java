package smarthouselib.controllers;

import smarthouselib.controllers.drivers.IControllerDriver;

/**
 * @author cameri
 * @since 6/6/13
 */
public interface IController
{

  void initialize(IControllerDriver driver);

  IControllerDriver getDriver();
}
