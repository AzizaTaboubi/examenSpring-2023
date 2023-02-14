package com.example.examenspringaziza.Repos;

import com.example.examenspringaziza.Entities.Participant;
import com.example.examenspringaziza.Entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {
    public Participant findParticipantByNomAndPrenom(String n, String p);
    public Participant findParticipantsByTache(Tache t);
}
