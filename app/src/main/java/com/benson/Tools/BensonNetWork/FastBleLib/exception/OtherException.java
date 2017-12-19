package com.benson.Tools.BensonNetWork.FastBleLib.exception;


public class OtherException extends BleException {
    public OtherException(String description) {
        super(ERROR_CODE_OTHER, description);
    }
}
