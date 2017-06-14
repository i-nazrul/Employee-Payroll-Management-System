/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazrul.dao;

import com.nazrul.model.Allowance;
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
public class AllowanceDao {
    
    private List<Allowance> list;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


public List<Allowance>getAllAllowance(){
    list = getSessionFactory().openSession().createCriteria(Allowance.class).list();    
    return list;
}
 @Transactional
    public void saveAllowance(Allowance all) {
        getSessionFactory().getCurrentSession().save(all);
    }
    
    
    public List<Allowance> searchAllowance(int id){
        String hql ="FROM Allowance s WHERE s.id='"+id+"' )";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    
    
    
}
