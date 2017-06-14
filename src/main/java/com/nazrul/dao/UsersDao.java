/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazrul.dao;
import com.nazrul.model.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersDao {

    private List< Users> list;
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean login(Users u) {
        try {

            Query query = getSessionFactory().openSession().createQuery("SELECT u FROM Users u WHERE u.username=:name AND u.password =:pass");
            query.setString("name", u.getUsername());
            query.setString("pass", u.getPassword());
            

            List<Users> cList = query.list();
            cList.toString();

//            
            if (cList.size() > 0) {
                System.out.println("OK");
                return true;
            } else {
                System.out.println("Not OKkkkkk");
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;

        }
    }

    public Users getId(int id) {
        return (Users) getSessionFactory().getCurrentSession().get(Users.class, id);
    }

    public List<Users> getUsers() {

//        String hql = "select * from Employee";
        list = getSessionFactory().openSession().createCriteria(Users.class).list();
        return list;

    }
    
   
    
    @Transactional
    public void saveUser(Users u) {
        getSessionFactory().getCurrentSession().save(u);
    }

    @Transactional
    public void updateUser(Users u) {
        getSessionFactory().getCurrentSession().update(u);
    }

//    @Transactional
//    public void deleteUser(Users u){
//    getSessionFactory().getCurrentSession().delete(u);
//    }
    @Transactional
    public void deleteUser(int id) {
        getSessionFactory().getCurrentSession().delete(getId(id));
    }
}
