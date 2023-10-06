package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Users;

public interface UserService {

    // Menambahkan user baru
    Users addUsers(Users users);

    // Mengupdate detail user
    Users updateUsers(Users users);

    // Menghapus user berdasarkan userId
    void deleteUsers(String usersId);

}
