/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.dao;

import com.jonak.entity.Contact;
import java.util.Collections;
import java.util.List;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.User;
/**
 *
 * @author Fahim Fahad
 */
public class ContactDaoImpl extends GenericDaoImpl<Contact, Integer> implements ContactDao{
    
    public ContactDaoImpl() {
        super(Contact.class);
    }
    
    @Override
    public List<Contact> getUserByID(int id) {       
        Session session = getHibernateTemplate().getSessionFactory().openSession();        
        List<Contact> contacts = session.createCriteria(Contact.class)
                .add(Restrictions.eq("id", id))                
                .list();
        session.close();
        return contacts.size()>0?contacts:Collections.emptyList();
    }
    
}
