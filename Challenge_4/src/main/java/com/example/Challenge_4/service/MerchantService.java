package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Merchant;

import java.util.List;

public interface MerchantService {

    // Menambahkan merchant baru
    Merchant addMerchant(Merchant merchant);

    // Mengedit status merchant (buka/tutup)
    Merchant editMerchantStatus(String merchantCode, boolean isOpen);

    // Menampilkan merchant yang sedang buka
    List<Merchant> getOpenMerchants();
}
