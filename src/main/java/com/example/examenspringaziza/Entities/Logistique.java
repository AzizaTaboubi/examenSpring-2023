package com.example.examenspringaziza.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Logistique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idLog;
    private String description;
    private boolean reserve;
    private float prixUnit;
    private int quantite;
}
