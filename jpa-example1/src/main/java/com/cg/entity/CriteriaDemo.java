package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> r = cq.from(Product.class);


//        cq.select(r);
//        List<Product> li = em.createQuery(cq).getResultList();
//        li.forEach(p-> System.out.println(p));
//
//        //Product whose price is greater than 30000
//        Predicate cond1 = cb.greaterThan(r.get("price"),30000);
//        cq.select(r).where(cond1);
//        List<Product> l2 = em.createQuery(cq).getResultList();
//        l2.forEach(p-> System.out.println(p));
//
//        //Get product whose name starts with M.
//        cq.select(r).where(cb.like(r.get("name"),"M%"));
//        List<Product> l3 = em.createQuery(cq).getResultList();
//        l3.forEach(p-> System.out.println(p));
//
//        Predicate cond2 = cb.greaterThan(r.get("price"),10000);
//        Predicate cond3 = cb.lessThan(r.get("price"),50000);
//        cq.select(r).where(cb.and(cond2,cond3));
////        cq.select(r).where(cb.or(cond2,cond3)); //implementing or operator
//        List<Product> l4 = em.createQuery(cq).getResultList();
//        l4.forEach(p-> System.out.println(p));

        cq.select(r).orderBy(cb.desc(r.get("qty")));
        List<Product> l5 = em.createQuery(cq).getResultList();
        l5.forEach(p-> System.out.println(p));

//        select product between cond2 & cond3 and order them by their name.
//        cq.select(r).where(cb.and(cond2,cond3)).orderBy(cb.asc(r.get("name")));




    }
}
