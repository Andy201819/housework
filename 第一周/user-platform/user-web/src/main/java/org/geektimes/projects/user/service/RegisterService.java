package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;
import java.util.ServiceLoader;

/**
 * @Author : wang feng
 * @create 2021/2/28 13:10
 */
public class RegisterService implements UserService {

    //public static final String databaseURL = "jdbc:derby:F:\\db\\user-platform";

    public static final String databaseURL = "jdbc:derby:/db/user-platform;create=true";

    private DBConnectionManager getDBConnectionManager(){
        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection connection = DriverManager.getConnection(databaseURL);
            //Connection connection = driver.connect(databaseURL,new Properties());
            ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
            DBConnectionManager manager = null;
            for(Driver driver:drivers){
                Connection connection = driver.connect(databaseURL,new Properties());
                manager = new DBConnectionManager();
                manager.setConnection(connection);
            }
//            DBConnectionManager manager = new DBConnectionManager();
//            manager.setConnection(connection);
            return manager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        DatabaseUserRepository databaseUserRepository = new DatabaseUserRepository(getDBConnectionManager());
        return databaseUserRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
