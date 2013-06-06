package smarthouselib;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import smarthouselib.drivers.IToggleableDriver;

/**
 *
 * @author Ricardo A Cabral
 */
public interface IDevice {
    void setID(String ID);
    String getID();
    void setCurrentState(DeviceState newState);
    DeviceState getCurrentState();
    DeviceCapabilities[] getCapabilities();
    void setDriver(IToggleableDriver newDriver);
    IToggleableDriver getDriver();
}
