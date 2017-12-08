package com.benson.BensonNetWork.FastBleLib.callback;


import com.benson.BensonNetWork.FastBleLib.bluetooth.BleConnector;
import com.benson.BensonNetWork.FastBleLib.exception.BleException;

public abstract class BleMtuChangedCallback {

    public abstract void onsetMTUFailure(BleException exception);

    public abstract void onMtuChanged(int mtu);

    private BleConnector bleConnector;

    public void setBleConnector(BleConnector bleConnector) {
        this.bleConnector = bleConnector;
    }

    public BleConnector getBleConnector() {
        return bleConnector;
    }

}
