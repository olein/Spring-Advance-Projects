/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.endpoint;

import com.jonak.entity.Contact;
import com.jonak.service.UserService;
import com.jonak.ws.services.CreateContactRequest;
import com.jonak.ws.services.CreateContactResponse;
import com.jonak.ws.services.DeleteContactRequest;
import com.jonak.ws.services.DeleteContactResponse;
import com.jonak.ws.services.UpdateContactRequest;
import com.jonak.ws.services.UpdateContactResponse;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 *
 * @author lenovo
 */
@RestController
@EnableAsync
public class UserServiceEndpoint {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createContact", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public @ResponseBody
    CreateContactResponse createContact(@RequestBody CreateContactRequest request) {
        CreateContactResponse response = new CreateContactResponse();
        if (request == null) {
            response.setResult(false);
        }

        if (request.getName() != null && request.getMobile() != null) {
            CompletableFuture<Boolean> result = userService.createContact(request);
            try {
                if (result.get()) {
                    response.setResult(Boolean.TRUE);
                } else {
                    response.setResult(Boolean.FALSE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

    @RequestMapping(value = "/updateContact", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public @ResponseBody
    UpdateContactResponse updateContact(@RequestBody UpdateContactRequest request) {
        UpdateContactResponse response = new UpdateContactResponse();
        if (request == null) {
            response.setResult(false);
        }

        if (request.getId() != 0) {
            CompletableFuture<Boolean> result = userService.updateContact(request);
            try {
                if (result.get()) {
                    response.setResult(Boolean.TRUE);
                } else {
                    response.setResult(Boolean.FALSE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public @ResponseBody
    DeleteContactResponse deleteContact(@RequestBody DeleteContactRequest request) {
        DeleteContactResponse response = new DeleteContactResponse();
        if (request == null) {
            response.setResult(false);
        }

        if (request.getId() != 0) {
            CompletableFuture<Boolean> result = userService.deleteContact(request);
            try {
                if (result.get()) {
                    response.setResult(Boolean.TRUE);
                } else {
                    response.setResult(Boolean.FALSE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(UserServiceEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

}
