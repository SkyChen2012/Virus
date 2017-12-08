package com.benson.BensonNetWork.FastBleLib.exception.hanlder;

import com.benson.BensonNetWork.FastBleLib.exception.ConnectException;
import com.benson.BensonNetWork.FastBleLib.exception.GattException;
import com.benson.BensonNetWork.FastBleLib.exception.NotFoundDeviceException;
import com.benson.BensonNetWork.FastBleLib.exception.OtherException;
import com.benson.BensonNetWork.FastBleLib.exception.TimeoutException;
import com.benson.BensonNetWork.FastBleLib.utils.BleLog;

public class DefaultBleExceptionHandler extends BleExceptionHandler {

    private static final String TAG = "BleExceptionHandler";

    public DefaultBleExceptionHandler() {

    }

    @Override
    protected void onConnectException(ConnectException e) {
        BleLog.e(TAG, e.getDescription());
    }

    @Override
    protected void onGattException(GattException e) {
        BleLog.e(TAG, e.getDescription());
    }

    @Override
    protected void onTimeoutException(TimeoutException e) {
        BleLog.e(TAG, e.getDescription());
    }

    @Override
    protected void onNotFoundDeviceException(NotFoundDeviceException e) {
        BleLog.e(TAG, e.getDescription());
    }

    @Override
    protected void onOtherException(OtherException e) {
        BleLog.e(TAG, e.getDescription());
    }
}
