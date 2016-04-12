package sv.kruk.service;

import sv.kruk.domain.User;

import java.util.List;

public interface UserService {

    public User registrUser(String username, String password);
    public User checkUser(String username, String password);

    List<User> getAll();
}
