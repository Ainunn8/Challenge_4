package com.example.Challenge_4.repository;

import com.example.Challenge_4.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    // Mengambil daftar merchant yang sedang buka
    public List<Merchant> findByIsOpen(boolean isOpen);

}
