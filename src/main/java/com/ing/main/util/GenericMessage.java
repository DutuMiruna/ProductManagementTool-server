/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.main.util;

/**
 *
 * @author mirun
 */
public class GenericMessage {

    private String errMsg;

    public GenericMessage() {
    }

    public GenericMessage(String errMsg) {

        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "GenericMessage{" + "errMsg=" + errMsg + '}';
    }

}
