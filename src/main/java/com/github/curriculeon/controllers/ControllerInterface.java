package com.github.curriculeon.controllers;

import com.github.curriculeon.service.ServiceInterface;

public interface ControllerInterface<ServiceType extends ServiceInterface> {
    ServiceType getService();
    void displayById();
    void displayAll();
    void delete();
    void update();
    void create();
}
