package com.benson.Tools.BensonNetWork.FastBleLib.exception;


public class TimeoutException extends BleException {
    public TimeoutException() {
        super(ERROR_CODE_TIMEOUT, "Timeout Exception Occurred!");
    }
}
