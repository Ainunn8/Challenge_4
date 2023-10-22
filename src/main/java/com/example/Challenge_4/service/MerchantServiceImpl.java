package com.example.Challenge_4.service;

import com.example.Challenge_4.model.Merchant;
import com.example.Challenge_4.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant editMerchantStatus(int merchantCode, String isOpen) {
//        return Optional.ofNullable(merchantRepository.findBy(String merchantCode, boolean isOpen));
//        return Optional<Merchant> merchantOptional = merchantRepository.findById(merchantId);
//        if (merchantOptional.isPresent()) {
//            Merchant merchant = merchantOptional.get();
//            merchant.setIsOpen(isOpen);
//            return merchantRepository.save(merchant);
//        }
        return null; // Merchant not found
    }

    @Override
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByIsOpen(true);
    }
}
