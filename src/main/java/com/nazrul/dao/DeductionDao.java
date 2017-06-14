/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazrul.dao;

import com.nazrul.model.Deductions;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nazrul
 */
@Repository
public class DeductionDao {
    private List< Deductions> list;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Deductions getId(int id) {
        return (Deductions) getSessionFactory().getCurrentSession().get(Deductions.class, id);
    }

    public List<Deductions> getDeduction() {

//        String hql = "select * from Employee";
        list = getSessionFactory().openSession().createCriteria(Deductions.class).list();
        return list;

    }
    public List<Deductions> getAllDeduction(int empid){
        String hql ="FROM Deductions s WHERE s.id not in ('"+empid+"')";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    
    public List<Deductions> searchDeduction(int id){
        String hql ="FROM Deductions s WHERE s.id='"+id+"' )";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    
    
    @Transactional
    public void saveDeduction(Deductions staff) {
        getSessionFactory().getCurrentSession().save(staff);
    }

    @Transactional
    public void updateDeduction(Deductions staff) {
        getSessionFactory().getCurrentSession().update(staff);
    }
}
