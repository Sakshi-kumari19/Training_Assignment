package com.cg.entity;

import jakarta.persistence.*;

import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

//        TypedQuery<Object[]> q = em.createQuery("select p from Product p", Product.class);

        //2 Ways to query multiple columns
//      TypedQuery<Object[]> q = em.createQuery("select p.name, p.price, p.mfd from Product p", Object[].class);
        //TypedQuery<ProductDTO> q = em.createQuery("select new ProductDTO(p.name, p.price, p.mfd) from Product p", ProductDTO.class);

        //TypedQuery<Product> q = em.createQuery("select p from Product p", Product.class);

//        TypedQuery<Product> q = em.createQuery("select p from Product p where p.price<:p", Product.class);
//        q.setParameter("p",20000);

        TypedQuery<Product> q = em.createQuery("select p from Product p where p.name like :p", Product.class);
        q.setParameter("p","M%");

        List<Product> pl = q.getResultList();

        //List<ProductDTO> pl = q.getResultList();

        pl.forEach(p-> System.out.println(p));

        em.getTransaction().begin();
        //Query to Class
//        Query q1 = em.createQuery("update Product p set p.price=10000 where p.pid=:p");  //:p is named Parameter
//        q1.setParameter("p",102);
//        int row = q1.executeUpdate();

//        Query to Table
//        Query q2 = em.createNativeQuery("update product_table p set p.price=10000 where p.pid=:p");
//        q2.setParameter("p",101);
//        int row = q2.executeUpdate();
//        em.getTransaction().commit();




    }


}
