package com.benson.BensonNetWork.FastBleLib.callback;

import com.benson.BensonNetWork.FastBleLib.bluetooth.BleConnector;
import com.benson.BensonNetWork.FastBleLib.exception.BleException;

public abstract class BleRssiCallback {

    public abstract void onRssiFailure(BleException exception);

    public abstract void onRssiSuccess(int rssi);

    private BleConnector bleConnector;

    public void setBleConnector(BleConnector bleConnector) {
        this.bleConnector = bleConnector;
    }

    public BleConnector getBleConnector() {
        return bleConnector;
    }
}