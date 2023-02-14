package com.example.examenspringaziza.Services;

import com.example.examenspringaziza.Entities.Evenement;
import com.example.examenspringaziza.Entities.Logistique;
import com.example.examenspringaziza.Entities.Participant;

import java.util.Date;
import java.util.List;

public interface ExamService {
 public Participant ajouterParticipant(Participant p);
 public Evenement ajoutAffectEvenParticip(Evenement e);
 public Logistique ajoutAffectLogEvnm(Logistique l , String descriptionEvnmt);
 public List<Logistique> getLogistiquesDates(Date dateDeb , Date dateFin);
 public List<Participant> getParReservLogis();
}
