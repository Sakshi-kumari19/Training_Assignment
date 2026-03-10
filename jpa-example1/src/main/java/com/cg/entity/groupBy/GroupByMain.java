package com.cg.entity.groupBy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class GroupByMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> r = cq.from(Employee.class);

        cq.multiselect(r.get("dept"),cb.count(r));
        cq.groupBy(r.get("dept"));
        TypedQuery<Object[]> tq = em.createQuery(cq);
        List<Object[]> ls = tq.getResultList();
        ls.forEach(p-> System.out.println("Department: "+p[0]+"\t"+"Total emp: "+p[1]));



    }
}
