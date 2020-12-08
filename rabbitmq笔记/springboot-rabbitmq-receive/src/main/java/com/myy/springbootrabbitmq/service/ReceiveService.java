package com.myy.springbootrabbitmq.service;

public interface ReceiveService {

    void receiveMessage();

    void autoReceiveMessage(String message);
}
