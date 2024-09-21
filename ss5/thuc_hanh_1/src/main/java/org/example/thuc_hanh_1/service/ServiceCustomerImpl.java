package org.example.thuc_hanh_1.service;

import org.example.thuc_hanh_1.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Service
public class ServiceCustomerImpl implements ServiceCustomer {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        Customer origin;
        if (customer.getId() == 0) {
            origin = new Customer();
        } else {
            origin = findById(customer.getId());
        }
        origin.setName(customer.getName());
        origin.setEmail(customer.getEmail());
        origin.setAddress(customer.getAddress());
        entityManager.persist(origin);
    }

    @Override
    public Customer findById(int id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        List<Customer> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void remove(int id) {
        try {
            Customer customer = findById(id);
            if (customer != null) {
                entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
