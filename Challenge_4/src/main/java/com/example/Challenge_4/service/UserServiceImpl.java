package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Users;
import com.example.Challenge_4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Users addUsers(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users updateUsers(Users users) {
        return userRepository.save(users);

    }

    @Override
    public void deleteUsers(String usersId) {
        // Mencari pengguna berdasarkan ID
        Users user = userRepository.findById(usersId).orElse(null);

        if (user != null) {
            // Menghapus pengguna dari basis data
            userRepository.delete(user);
            System.out.println("Pengguna dengan ID " + usersId + " berhasil dihapus.");
        } else {
            System.out.println("Pengguna dengan ID " + usersId + " tidak ditemukan.");
        }
//        userRepository.deleteById(usersId);
    }
}
