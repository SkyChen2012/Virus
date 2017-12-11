package com.benson.virus.Bluetooth.comm;


import com.benson.BensonNetWork.FastBleLib.data.BleDevice;

public interface Observer {

    void disConnected(BleDevice bleDevice);
}
