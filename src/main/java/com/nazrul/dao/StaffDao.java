package com.nazrul.dao;

import com.nazrul.model.StaffInformation;
import com.nazrul.model.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nazrul
 */
@Repository
public class StaffDao {

    private List< StaffInformation> list;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public StaffInformation getId(int id) {
        return (StaffInformation) getSessionFactory().getCurrentSession().get(StaffInformation.class, id);
    }

    public List<StaffInformation> getStaff() {

//        String hql = "select * from Employee";
        list = getSessionFactory().openSession().createCriteria(StaffInformation.class).list();
        return list;

    }
    public List<StaffInformation> getAllStaff(int empid){
        String hql ="FROM StaffInformation s WHERE s.id not in ('"+empid+"')";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    
    public List<StaffInformation> searchStaff(int id){
        String hql ="FROM StaffInformation s WHERE s.id='"+id+"' )";
        Query query = getSessionFactory().openSession().createQuery(hql);
         list = query.list();
         return list;
    }
    
    
    @Transactional
    public void saveStaff(StaffInformation staff) {
        getSessionFactory().getCurrentSession().save(staff);
    }

    @Transactional
    public void updateStaff(StaffInformation staff) {
        getSessionFactory().getCurrentSession().update(staff);
    }

//    @Transactional
//    public void deleteUser(Users u){
//    getSessionFactory().getCurrentSession().delete(u);
//    }
    @Transactional
    public void deleteStaff(int id) {
        getSessionFactory().getCurrentSession().delete(getId(id));
    }
}
