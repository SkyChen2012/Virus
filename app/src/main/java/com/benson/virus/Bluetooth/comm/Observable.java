package com.benson.virus.Bluetooth.comm;


import com.benson.BensonNetWork.FastBleLib.data.BleDevice;

public interface Observable {

    void addObserver(Observer obj);

    void deleteObserver(Observer obj);

    void notifyObserver(BleDevice bleDevice);
}
