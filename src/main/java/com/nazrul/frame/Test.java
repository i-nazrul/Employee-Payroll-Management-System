/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazrul.frame;

import com.nazrul.model.*;
import com.nazrul.dao.*;
import com.nazrul.model.Users;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Nazrul
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
        UsersDao ud = context.getBean(UsersDao.class);
        StaffDao sd = context.getBean(StaffDao.class);
//ud.saveUser(new Users("Roktim", "123", "IT"));
//List<Users> ulist = ud.getUsers();
//        for (Users u : ulist) {
//            System.out.println(u.getEmpId());
//            List<StaffInformation>slist = sd.getAllStaff(u.getEmpId());
//            for(StaffInformation s:slist){
//                System.out.println(s.getId());
//                System.out.println(s.getFirstName());
//                System.out.println(s.getDob().replace("-", ""));
//                System.out.println(s.getDepartment());
//                
//                 
//                 ud.saveUser(new Users(s.getFirstName(),s.getDob().replace("-", "") ,s.getDepartment(),s.getId()));
//                
//            }
//        }
           // ud.deleteUser(1);
           //ud.deleteUser(new Users("Roktim"));

          
        System.out.println(sd.searchStaff(1));
           
           
}
}