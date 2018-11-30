/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Filiere;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author root
 */
public class FiliereService implements IDao<Filiere> {

    @Override
    public boolean create(Filiere t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            session.close();
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Filiere t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean delete(Filiere t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
    }

    @Override
    public Filiere findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Filiere filiere = null;
        
        try {
            tx = session.beginTransaction();
            filiere = (Filiere) session.get(Filiere.class, id);
            tx.commit();
            session.close();
            return filiere;
        } catch (Exception e) {
            if(tx != null ){
                tx.rollback();
            }
            session.close();
            return filiere;
        }
    }

    @Override
    public List<Filiere> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Filiere> filieres = null;
        try {
            String hql = "from Filiere";
            tx = session.beginTransaction();
            filieres = session.createQuery(hql).list();
            tx.commit();
            session.close();
            return filieres;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return filieres;
        }
    }
    
    public List<Object> graphFiliere() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Object> filieres = null;
        try {
            String hql = "SELECT F.code ,count(*) From Filiere F GROUP BY F.code";
            tx = session.beginTransaction();
            filieres = session.createQuery(hql).list();
            tx.commit();
            session.close();
            return filieres;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return filieres;
        }
    }
        

}
