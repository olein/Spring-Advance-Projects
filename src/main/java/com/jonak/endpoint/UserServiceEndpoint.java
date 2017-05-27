/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.endpoint;
import com.jonak.entity.Contact;
import com.jonak.service.UserService;
import com.netizen.smsgateway.ws.services.LoginRequest;
import com.netizen.smsgateway.ws.services.LoginResponse;
import com.netizen.smsgateway.ws.services.LoginWithNameRequest;
import com.netizen.smsgateway.ws.services.LoginWithNameResponse;
import com.netizen.smsgateway.ws.services.CreateUserRequest;
import com.netizen.smsgateway.ws.services.CreateUserResponse;
import com.netizen.smsgateway.ws.services.CreateUserWithDetailRequest;
import com.netizen.smsgateway.ws.services.CreateUserWithDetailResponse;
import com.netizen.smsgateway.ws.services.UpdateUserRequest;
import com.netizen.smsgateway.ws.services.UpdateUserResponse;
import com.netizen.smsgateway.ws.services.DeleteUserRequest;
import com.netizen.smsgateway.ws.services.DeleteUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;
/**
 *
 * @author lenovo
 */
@Endpoint
public class UserServiceEndpoint {
    
    @Autowired
    UserService userService;

    @PayloadRoot(localPart = "loginRequest", namespace = "http://ws.smsgateway.netizen.com/services")
    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
    public @ResponsePayload
    LoginResponse getLoginResponse(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();
        if (request != null) {
            Boolean output = userService.checkUserLogin(request.getUserObj());            
            response.setResult(output);            
        }
        return response;
    }
    
     @PayloadRoot(localPart = "loginWithNameRequest", namespace = "http://ws.smsgateway.netizen.com/services")
    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
    public @ResponsePayload
    LoginWithNameResponse getLoginWithNameResponse(@RequestPayload LoginWithNameRequest request) {
        LoginWithNameResponse response = new LoginWithNameResponse();
        if (request != null) {
            Boolean output = userService.checkUserLoginByName(request.getUserObj());            
            response.setResult(output);            
        }
        return response;
    }
    
    
   
    
//    @PayloadRoot(localPart = "createUserWithDetailRequest", namespace = "http://ws.smsgateway.netizen.com/services")
//    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
//    public @ResponsePayload
//    CreateUserWithDetailResponse createUserWithDetailRequest(@RequestPayload CreateUserWithDetailRequest request) {
//        CreateUserWithDetailResponse response = new CreateUserWithDetailResponse();
//        if (request != null) {
//            Boolean output = userService.createUser(request.);            
//            response.setResult(output);            
//        }
//        return response;
//    }
    
    @PayloadRoot(localPart = "createUserRequest", namespace = "http://ws.smsgateway.netizen.com/services")
    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
    public @ResponsePayload
    CreateUserResponse createUserResponse(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        if (request != null) {
            Boolean output = userService.createUser(request.getUserObj());            
            response.setResult(output);            
        }
        return response;
    }
    
    @PayloadRoot(localPart = "updateUserRequest", namespace = "http://ws.smsgateway.netizen.com/services")
    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
    public @ResponsePayload
    UpdateUserResponse updateUserResponse(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        if (request != null) {
            Boolean output = userService.updateUser(request.getUserObj());            
            response.setResult(output);            
        }
        return response;
    }
    
    @PayloadRoot(localPart = "deleteUserRequest", namespace = "http://ws.smsgateway.netizen.com/services")
    //@SoapAction("http://ws.smsgateway.netizen.com/services/loginRequest")
    public @ResponsePayload
    DeleteUserResponse deleteUserResponse(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        if (request != null) {
            Boolean output = userService.deleteUser(request.getUserId());            
            response.setResult(output);            
        }
        return response;
    }
    
}
