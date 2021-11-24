package apap.tutorial.emsidi.service;

import java.util.List;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(user.getPassword());
        if (m.matches()) {
            String pass = encrypt(user.getPassword());
            user.setPassword(pass);
            return userDb.save(user);
        } else {
            return null;
        }
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public UserModel updateUserPassword(UserModel user, String oldPass, String newPass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean m = passwordEncoder.matches(oldPass, user.getPassword());
        if (m) {
            user.setPassword(newPass);
            return addUser(user);
        }
        return null;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public UserModel deleteUser(UserModel user) {
        userDb.delete(user);
        return null;
    }

}
