package apap.tutorial.emsidi.service;

import java.util.List;

import apap.tutorial.emsidi.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    List<UserModel> getListUser();

    UserModel deleteUser(UserModel user);

    UserModel updateUserPassword(UserModel user, String oldPass, String newPass);

    UserModel getUserByUsername(String username);
}
