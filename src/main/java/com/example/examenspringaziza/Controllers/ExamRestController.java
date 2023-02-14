package com.example.examenspringaziza.Controllers;

import com.example.examenspringaziza.Entities.Evenement;
import com.example.examenspringaziza.Entities.Logistique;
import com.example.examenspringaziza.Entities.Participant;
import com.example.examenspringaziza.Services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/examspring")
public class ExamRestController {
    @Autowired
    ExamService examService;
    @PostMapping("/addparticipant")
    Participant addP(@RequestBody Participant p){
        return examService.ajouterParticipant(p);
    }

    @PostMapping("/addev")
    Evenement eddev(@RequestBody Evenement e){
        return examService.ajoutAffectEvenParticip(e);
    }
    @PostMapping("/addlogaffect/{d}")
    Logistique addlogaffect(@RequestBody Logistique l, @PathVariable("d") String d){
        return examService.ajoutAffectLogEvnm(l, d);
    }

    @GetMapping("/getlogdate/{dd}/{df}")
    List<Logistique> getlogdate(@PathVariable("dd")@DateTimeFormat(pattern = "yyyy-mm-dd") Date dd, @PathVariable("df") @DateTimeFormat(pattern = "yyyy-mm-dd") Date df){
        return examService.getLogistiquesDates(dd, df);
    }
    @GetMapping("/getlogsfalse")
    List<Participant> getlogsfalse(){
        return examService.getParReservLogis();
    }
}
