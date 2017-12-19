package com.benson.Tools.Bluetooth.comm;


import com.benson.Tools.BensonNetWork.FastBleLib.data.BleDevice;

public interface Observer {

    void disConnected(BleDevice bleDevice);
}
