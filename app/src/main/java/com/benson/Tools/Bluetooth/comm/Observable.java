package com.benson.Tools.Bluetooth.comm;


import com.benson.Tools.BensonNetWork.FastBleLib.data.BleDevice;

public interface Observable {

    void addObserver(Observer obj);

    void deleteObserver(Observer obj);

    void notifyObserver(BleDevice bleDevice);
}
