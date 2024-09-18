package org.example.bai_tap_1.service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Override
    public double currencyConverter(double amount) {
        return amount * 23000;
    }
}
