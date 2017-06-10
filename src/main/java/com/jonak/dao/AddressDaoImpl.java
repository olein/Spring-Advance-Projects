/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.dao;

import com.jonak.entity.Address;

/**
 *
 * @author Fahim Fahad
 */
public class AddressDaoImpl extends GenericDaoImpl<Address, Integer> implements AddressDao {

    public AddressDaoImpl() {
        super(Address.class);
    }

//    public User getUserByName(String name) {       
//        Session session = getHibernateTemplate().getSessionFactory().openSession();        
//        List<User> user = session.createCriteria(User.class)
//                .add(Restrictions.eq("name", name))                
//                .list();
//        return user.size()>0?user.get(0):null;
//    }
}
