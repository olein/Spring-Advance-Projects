/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.service;

import com.netizen.user.ws.userbean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lenovo
 */
@Component
public class UserServiceImp implements UserService { 

    @Override
    public Boolean checkUserLogin(UserBean userobj) {       
        return Boolean.FALSE;
    }
    
    @Override
    public Boolean checkUserLoginByName(UserBean userobj) {        
        return Boolean.FALSE;
    }

    @Override
    public Boolean createUser(UserBean userobj) {       
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateUser(UserBean userobj) {       
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteUser(int userId) {        
        return Boolean.TRUE;        
    }
}
