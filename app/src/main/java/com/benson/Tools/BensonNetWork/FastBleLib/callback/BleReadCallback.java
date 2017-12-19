package com.benson.Tools.BensonNetWork.FastBleLib.callback;

import com.benson.Tools.BensonNetWork.FastBleLib.bluetooth.BleConnector;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.BleException;

public abstract class BleReadCallback {

    public abstract void onReadSuccess(byte[] data);

    public abstract void onReadFailure(BleException exception);

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
