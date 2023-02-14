package com.example.examenspringaziza.Repos;

import com.example.examenspringaziza.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
    public Evenement findEvenementByDescription(String d);
    @Query(value = "SELECT SUM(prix_unit)" +"FROM Logistique l"+ " INNER JOIN Evenement e on e.logistiques = l.idLog WHERE e.logistiques = l.idLog",nativeQuery = true )
    void CalculCout();
}


