package com.benson.BensonNetWork.FastBleLib.callback;

import com.benson.BensonNetWork.FastBleLib.bluetooth.BleConnector;
import com.benson.BensonNetWork.FastBleLib.exception.BleException;

public abstract class BleNotifyCallback {

    public abstract void onNotifySuccess();

    public abstract void onNotifyFailure(BleException exception);

    public abstract void onCharacteristicChanged(byte[] data);

    private String key;

    private BleConnector bleConnector;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setBleConnector(BleConnector bleConnector) {
        this.bleConnector = bleConnector;
    }

    public BleConnector getBleConnector() {
        return bleConnector;
    }


}
