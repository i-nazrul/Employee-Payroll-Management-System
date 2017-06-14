/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazrul.dao;

import com.nazrul.model.Audit;

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
public class AuditDao {
    private List<Audit> list;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
        @Transactional
    public void saveAduit(Audit a) {
        getSessionFactory().getCurrentSession().save(a);
    }

    public List<Audit>getAllAudit(){
    list = getSessionFactory().openSession().createCriteria(Audit.class).list();    
    return list;
}
    public List<Audit> searchAudit(int id){
        String hql ="FROM Audit s WHERE s.emp_id='"+id+"' )";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    

}
