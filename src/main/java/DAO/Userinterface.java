package DAO;

import model.User;

public interface Userinterface {
public void register(User user);
public boolean login(User user); 
public boolean checkuser(User user);
}
