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

    private String message;

    public GenericMessage() {
    }

    public GenericMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GenericMessage{" + "message=" + message + '}';
    }

}
