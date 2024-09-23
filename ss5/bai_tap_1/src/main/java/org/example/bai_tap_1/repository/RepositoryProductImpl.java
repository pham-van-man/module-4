package org.example.bai_tap_1.repository;

import org.example.bai_tap_1.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Transactional
@Repository
public class RepositoryProductImpl implements RepositoryProduct {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getProducts(Product product) {
        String query = "SELECT p FROM Product p WHERE p.name LIKE :name AND p.price BETWEEN :minPrice AND :maxPrice";
        TypedQuery<Product> q = em.createQuery(query, Product.class);
        if (product.getName() == null) {
            product.setName("");
        }
        q.setParameter("name", "%" + product.getName() + "%");
        if (product.getPrice() == 0) {
            q.setParameter("minPrice", 0.0);
            q.setParameter("maxPrice", 999999999.0);
        } else {
            q.setParameter("minPrice", product.getPrice());
            q.setParameter("maxPrice", product.getPrice());
        }
        return q.getResultList();
    }

    @Override
    public Product getProduct(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public void saveProduct(Product product) {
        if (product.getId() == 0) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        em.remove(em.find(Product.class, id));
    }
}