package apap.tutorial.emsidi.service;

import java.util.List;

import apap.tutorial.emsidi.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    List<UserModel> getListUser();

    UserModel deleteUser(UserModel user);

    boolean validasiPassword(UserModel user, String password);

    UserModel updatePassword(UserModel user, String password);

    UserModel getUserByUsername(String username);
}
