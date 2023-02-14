package com.example.examenspringaziza.Services;


import com.example.examenspringaziza.Entities.Evenement;
import com.example.examenspringaziza.Entities.Logistique;
import com.example.examenspringaziza.Entities.Participant;
import com.example.examenspringaziza.Entities.Tache;
import com.example.examenspringaziza.Repos.EvenementRepo;
import com.example.examenspringaziza.Repos.LogistiqueRepo;
import com.example.examenspringaziza.Repos.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExamServiceIMP implements ExamService{
    @Autowired
    ParticipantRepo participantRepo;
    @Autowired
    EvenementRepo evenementRepo;
    @Autowired
    LogistiqueRepo logistiqueRepo;
    @Override
    public Participant ajouterParticipant(Participant p) {
        return participantRepo.save(p);
    }

    @Override
    public Evenement ajoutAffectEvenParticip(Evenement e) {

     // List<Participant> participants =  e.getParticipants();
     //   for (Participant p: participants) {
      //      p.getEvenements().add(e);
       // }
        return evenementRepo.save(e);
    }

    @Override
    public Logistique ajoutAffectLogEvnm(Logistique l, String descriptionEvnmt) {
        Evenement e = evenementRepo.findEvenementByDescription(descriptionEvnmt);
        e.getLogistiques().add(l);
        return logistiqueRepo.save(l);
    }

    @Override
    public List<Logistique> getLogistiquesDates(Date dateDeb, Date dateFin) {
        List<Evenement> e = evenementRepo.findAll();
        List<Logistique> liste = new ArrayList<>();
        for (Evenement ev: e) {
            if ((ev.getDateDebute().after(dateDeb)) && (ev.getDateFin().before(dateFin))){
                liste = ev.getLogistiques();
            }
            
        }
        return liste;
    }

    @Override
    public List<Participant> getParReservLogis() {
        List<Evenement> e = evenementRepo.findAll();
        List<Participant> liste = new ArrayList<>();
        for (Evenement evenement : e) {
           List<Participant> participants = evenement.getParticipants();
           List<Logistique> logistiques = evenement.getLogistiques();
            for (Participant p: participants ) {
                if (p.getTache()==Tache.ORGANISATEUR){
                    for (Logistique l: logistiques ) {
                        if (l.isReserve()==false){
                          liste.add(p);
                        }
                    }
                }
            }
        }
        return liste;
    }
    @Scheduled(fixedRate = 60000)
    public void calculCout(){
      evenementRepo.CalculCout();
    }
}
