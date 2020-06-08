package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {

    @GetMapping("/")
    public String index() {
        return "index.html"; // you can also write return "home.html"
    }


    @GetMapping("/doctor/{snumber}")
    @ResponseBody
    public Object doctor(@PathVariable String snumber) {
        int number = Integer.parseInt(snumber);
       
        if (number >0 && number <13){
            return "Erreur 303";
        }

        if (number == 13){
            return new Doctor(number, "Jodie Whittaker"); 
        }

        return "Erreur 404 - Impossible de récupérer l'incarnation " + number;
        
            
       
        
    }
}
