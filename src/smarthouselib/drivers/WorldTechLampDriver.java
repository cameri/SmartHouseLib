package smarthouselib.drivers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo A Cabral
 */
public class WorldTechLampDriver implements IToggleableDriver {

  @Override
  public void turnOn() {
    System.out.println("Turning lamp on.");
  }

  @Override
  public void turnOff() {
    System.out.println("Turning lamp off.");
  }
    
}
