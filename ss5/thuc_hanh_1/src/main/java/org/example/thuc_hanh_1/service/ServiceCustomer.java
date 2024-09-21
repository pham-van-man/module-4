package org.example.thuc_hanh_1.service;

import org.example.thuc_hanh_1.model.Customer;

import java.util.List;

public interface ServiceCustomer {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}
