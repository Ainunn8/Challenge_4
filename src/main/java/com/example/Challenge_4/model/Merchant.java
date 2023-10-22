package com.example.Challenge_4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {
    @Id
    private int merchantCode;
    private String nameMerchant;
    private String location;
    private String isOpen;


}
