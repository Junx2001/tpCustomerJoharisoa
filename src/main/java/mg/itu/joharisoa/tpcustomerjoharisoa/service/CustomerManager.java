/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.joharisoa.tpcustomerjoharisoa.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.joharisoa.tpcustomerjoharisoa.entity.Customer;

/**
 * Gère la persistance des Customers.
 *
 * @author xxxx
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Pour insérer un Customer dans la base de données
     *
     * @param customer
     */
    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Pour récuperer la liste des Customers
     *
     * @return List
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }

    /**
     * Pour modifier un Customer dans la base de données
     *
     * @param customer
     * @return Customer
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
}
