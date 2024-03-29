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
import mg.itu.joharisoa.tpcustomerjoharisoa.entity.Discount;

/**
 * Gère la persistance des Discount.
 *
 * @author xxxx
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext
    private EntityManager em;

    /**
     * Pour récuperer la liste des Discounts
     *
     * @return List
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
