package com.cg.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class EmployeeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        PEmployee obj = new PEmployee();
        obj.setName("Sakshi");
        obj.setDob(LocalDate.of(2003,2,3));
        obj.setSalary(60000);
        em.persist(obj);

        CEmployee obj2 = new CEmployee();
        obj2.setName("Tanya");
        obj2.setDob(LocalDate.of(2002,4,3));
        obj2.setPay_per_hour(5000);
        em.persist(obj2);
        em.getTransaction().commit();
    }
}
