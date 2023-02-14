package com.example.examenspringaziza.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateDebute;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private float count;
    @ManyToMany(mappedBy = "evenements")
    private List<Participant> participants;
    @OneToMany
    private List<Logistique> logistiques;
}
