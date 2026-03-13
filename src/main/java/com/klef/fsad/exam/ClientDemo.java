package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        ClientDemo cd = new ClientDemo();
        cd.insertDelivery();
        cd.deleteDelivery("101");
    }

    // I. Insert record using persistent object
    public void insertDelivery()
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Delivery d = new Delivery();
        d.setId("101");
        d.setName("Pedigree");
        d.setDate("13-03-2026");
        d.setStatus("Delivered");

        Transaction t = session.beginTransaction();

        session.persist(d);

        t.commit();

        System.out.println("Delivery Inserted Successfully");

        session.close();
        sf.close();
    }

    // II. Delete record using HQL with positional parameter
    public void deleteDelivery(String did)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        String hql = "delete from Delivery where id=?1";

        Query query = session.createQuery(hql);
        query.setParameter(1, did);

        int n = query.executeUpdate(); // n records updated

        t.commit();

        System.out.println(n + " Record Deleted");

        session.close();
        sf.close();
    }
}