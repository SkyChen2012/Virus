package com.benson.BensonNetWork.FastBleLib.callback;

import com.benson.BensonNetWork.FastBleLib.data.BleDevice;

public abstract class BleScanAndConnectCallback extends BleGattCallback {

    public abstract void onScanStarted(boolean success);

    public abstract void onScanFinished(BleDevice scanResult);

}
