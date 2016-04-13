package sv.kruk.service;

import sv.kruk.domain.User;

import java.util.List;

/**
 * method for use user
 */
public interface UserService {

    public User registrationUser(String username, String password);
    public User verificationUser(String username, String password);

    List<User> getAll();
}
