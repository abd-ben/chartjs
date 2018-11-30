/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Etudiant;
import dao.IDao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author root
 */
public class EtudiantService implements IDao<Etudiant> {

    @Override
    public boolean create(Etudiant t) {
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
    public boolean update(Etudiant t) {
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
    public boolean delete(Etudiant t) {
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
    public Etudiant findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Etudiant etudiant = null;
        
        try {
            tx = session.beginTransaction();
            etudiant = (Etudiant) session.get(Etudiant.class, id);
            tx.commit();
            session.close();
            return etudiant;
        } catch (Exception e) {
            if(tx != null ){
                tx.rollback();
            }
            session.close();
            return etudiant;
        }
    }

    @Override
    public List<Etudiant> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Etudiant> etudiants = null;
        try {
            String hql = "form Etudiant";
            tx = session.beginTransaction();
            etudiants = session.createQuery(hql).list();
            tx.commit();
            session.close();
            return etudiants;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            return etudiants;
        }
    }

}
