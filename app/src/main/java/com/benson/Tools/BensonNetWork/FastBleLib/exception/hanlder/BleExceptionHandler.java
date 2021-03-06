package com.benson.Tools.BensonNetWork.FastBleLib.exception.hanlder;

import com.benson.Tools.BensonNetWork.FastBleLib.exception.BleException;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.ConnectException;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.GattException;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.NotFoundDeviceException;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.OtherException;
import com.benson.Tools.BensonNetWork.FastBleLib.exception.TimeoutException;


public abstract class BleExceptionHandler {

    public BleExceptionHandler handleException(BleException exception) {

        if (exception != null) {

            if (exception instanceof ConnectException) {
                onConnectException((ConnectException) exception);

            } else if (exception instanceof GattException) {
                onGattException((GattException) exception);

            } else if (exception instanceof TimeoutException) {
                onTimeoutException((TimeoutException) exception);

            } else if (exception instanceof NotFoundDeviceException) {
                onNotFoundDeviceException((NotFoundDeviceException) exception);

            } else {
                onOtherException((OtherException) exception);
            }
        }
        return this;
    }

    /**
     * connect failed
     */
    protected abstract void onConnectException(ConnectException e);

    /**
     * gatt error status
     */
    protected abstract void onGattException(GattException e);

    /**
     * operation timeout
     */
    protected abstract void onTimeoutException(TimeoutException e);

    /**
     * not found device error
     */
    protected abstract void onNotFoundDeviceException(NotFoundDeviceException e);

    /**
     * other exceptions
     */
    protected abstract void onOtherException(OtherException e);
}
