package sv.kruk.service.imp;

import sv.kruk.dao.UserDao;
import sv.kruk.dao.imp.UserDaoImp;
import sv.kruk.domain.User;
import sv.kruk.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements UserService {

    private static volatile UserServiceImp instance;

    private UserServiceImp(){}

    /**
     * singleton
     * @return
     */
    public static UserServiceImp getInstance(){
        if (instance == null) {
            synchronized (UserServiceImp.class){
                if (instance == null) {
                    instance = new UserServiceImp();
                }
            }
        }
        return  instance;
    }

    /**
     * registration new user of username and password
     * @param username
     * @param password
     * @return new user
     */
    public User registrationUser(String username, String password) {
        if (username != null && password != null) {
            User user = new User(username, password);
            UserDao userDao = UserDaoImp.getInstance();
            try {
                userDao.save(user);
                user = userDao.getUserByUsername(username);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return user;
        }
        return null;
    }

    /**
     * check user of equals password in db and form parameter
     * @param username
     * @param password
     * @return
     */
    public User verificationUser(String username, String password) {
        if (username.equals("") || password.equals("")){
            return null;
        }
        UserDao userDao = UserDaoImp.getInstance();
        User user = new User(username, password);
        User userDb = null;
        try {
            userDb = userDao.getUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userDb != null && userDb.equals(user)) {
            return userDb;
        }else {
            return null;
        }

    }

    /**
     * get all user from db
     * @return
     */
    public List<User> getAll() {
        UserDao userDao = UserDaoImp.getInstance();
        List<User> users = null;
        try {
            users = userDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
