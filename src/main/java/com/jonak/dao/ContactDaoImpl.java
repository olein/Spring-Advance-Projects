/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.dao;

import com.jonak.entity.Contact;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Fahim Fahad
 */
public class ContactDaoImpl extends GenericDaoImpl<Contact, Integer> implements ContactDao{
    
    public ContactDaoImpl() {
        super(Contact.class);
    }
    
//    public User getUserByName(String name) {       
//        Session session = getHibernateTemplate().getSessionFactory().openSession();        
//        List<User> user = session.createCriteria(User.class)
//                .add(Restrictions.eq("name", name))                
//                .list();
//        return user.size()>0?user.get(0):null;
//    }
    
}
