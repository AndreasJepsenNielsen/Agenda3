package com.agenda.demo;

import org.apache.catalina.User;


import java.util.List;

public interface IUserRepository{

    List GetAll();
    User Find(int id);
    User Add(User user);
    User Update(User user);
    void Remove(int id);
    User GetUserInformatiom(int id);
}
