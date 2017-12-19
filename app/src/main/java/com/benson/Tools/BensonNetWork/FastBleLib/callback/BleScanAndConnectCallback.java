package com.benson.Tools.BensonNetWork.FastBleLib.callback;

import com.benson.Tools.BensonNetWork.FastBleLib.data.BleDevice;

public abstract class BleScanAndConnectCallback extends BleGattCallback {

    public abstract void onScanStarted(boolean success);

    public abstract void onScanFinished(BleDevice scanResult);

}
