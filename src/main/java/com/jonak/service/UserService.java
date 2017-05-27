/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.service;
import com.netizen.user.ws.userbean.UserBean;
/**
 *
 * @author lenovo
 */
public interface UserService { 
    
    public Boolean checkUserLogin(UserBean userobj);
    
    public Boolean checkUserLoginByName(UserBean userobj);
    
    public Boolean createUser(UserBean userobj);
    
    public Boolean updateUser(UserBean userobj);
    
    public Boolean deleteUser(int userId);
    
}
