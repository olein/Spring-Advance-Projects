/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.service;

import com.jonak.dao.AddressDao;
import com.jonak.entity.Address;
import com.jonak.entity.Contact;
import com.jonak.dao.ContactDao;
import com.jonak.ws.services.CreateContactRequest;
import com.jonak.ws.services.DeleteContactRequest;
import com.jonak.ws.services.UpdateContactRequest;
import com.nuspay.payment.smart_travel_card.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author lenovo
 */
@Component
public class UserServiceImp implements UserService {

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private AddressDao addressDao;

    @Async
    @Override
    public CompletableFuture<Boolean> createContact(CreateContactRequest request) {

        try {
            Address address = new Address();
            address.setHouse(request.getHouse());
            address.setStreet(request.getStreet());
            //addressDao.createOrUpdate(address);

            Contact contact = new Contact();
            contact.setName(request.getName());
            contact.setBirthday(request.getBirthday());
            contact.setDescription(request.getDescription());
            contact.setEmail(request.getEmail());
            contact.setIsFnf(request.isIsFnF());
            contact.setMobile(request.getMobile());
            contact.setTypeOfContact(request.getTypeOfContact());
            contact.setAddress(address);

            contactDao.createOrUpdate(contact);
            return CompletableFuture.completedFuture(true);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return CompletableFuture.completedFuture(false);
        }
    }

    @Async
    @Override
    public CompletableFuture<Boolean> updateContact(UpdateContactRequest request) {

        try {
            Contact contact = contactDao.read(request.getId());

            if (contact != null) {
                Address address = contact.getAddress();
                address.setHouse(request.getHouse());
                address.setStreet(request.getStreet());

                contact.setName(request.getName());
                contact.setBirthday(request.getBirthday());
                contact.setDescription(request.getDescription());
                contact.setEmail(request.getEmail());
                contact.setIsFnf(request.isIsFnF());
                contact.setMobile(request.getMobile());
                contact.setTypeOfContact(request.getTypeOfContact());
                contact.setAddress(address);

                contactDao.createOrUpdate(contact);

                return CompletableFuture.completedFuture(true);
            } else {
                return CompletableFuture.completedFuture(false);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return CompletableFuture.completedFuture(false);
        }
    }

    @Async
    @Override
    public CompletableFuture<Boolean> deleteContact(DeleteContactRequest request) {

        try {
            Contact contact = contactDao.read(request.getId());
            System.out.println("done");
            if (contact != null) {
                contactDao.delete(contact);
                return CompletableFuture.completedFuture(true);
            } else {
                return CompletableFuture.completedFuture(false);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return CompletableFuture.completedFuture(false);
        }
    }

    @Async
    @Override
    public CompletableFuture<List<Contact>> getContactList() {

        try {
            Criteria criteria = HibernateUtil.buildSessionFactory().openSession().createCriteria(Contact.class);
            List<Contact> contacts = criteria.list();

            System.out.println(contacts.size());
            if (contacts != null) {
                return CompletableFuture.completedFuture(contacts);
            } else {
                return CompletableFuture.completedFuture(Collections.emptyList());
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return CompletableFuture.completedFuture(Collections.emptyList());
        }
    }

}
