/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.service;

import com.jonak.entity.Contact;
import com.jonak.ws.services.CreateContactRequest;
import com.jonak.ws.services.DeleteContactRequest;
import com.jonak.ws.services.UpdateContactRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author lenovo
 */
public interface UserService {

    public CompletableFuture<Boolean> createContact(CreateContactRequest request);

    public CompletableFuture<Boolean> updateContact(UpdateContactRequest request);
    
    public CompletableFuture<Boolean> deleteContact(DeleteContactRequest request);
    
    public CompletableFuture<List<Contact>> getContactList();    

}
