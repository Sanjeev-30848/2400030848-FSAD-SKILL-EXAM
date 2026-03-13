package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo 
{
    // insert records using persistent object
    public void addDelivery()
    {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

        Delivery delivery = new Delivery();
        delivery.setId("101");
        delivery.setStatus("Delivered");
        delivery.setName("Pedigree");
        delivery.setDate("13-02-2026");

        Transaction t = session.beginTransaction();

        session.persist(delivery); // inserting object

        t.commit();
        System.out.println("Delivery Inserted Successfully");

        session.close();
        sf.close();
    }
}