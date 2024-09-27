package com.example.lab5_20216256.controller;


import com.example.lab5_20216256.entity.Viajes;
import com.example.lab5_20216256.repository.LugaresRepository;
import com.example.lab5_20216256.repository.PersonaRepository;
import com.example.lab5_20216256.repository.ViajesRepository
        ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ViajesController {
    private final ViajesRepository viajesRepository;
    private final PersonaRepository personaRepository;
    private final LugaresRepository lugaresRepository;

    int i=100;

    public ViajesController(ViajesRepository viajesRepository,
                            PersonaRepository personaRepository,
                            LugaresRepository lugaresRepository) {
        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.lugaresRepository = lugaresRepository;
    }



    @GetMapping("/ListarViajes")
    public String listarViajes(Model model) {

        List<Viajes> lista = viajesRepository.findAll();


        model.addAttribute("Viajes", lista);


        return "ListaViajesProgramados";
    }




    @GetMapping("/nuevoViaje")
    public String nuevaDistribuidora(Model model){
        model.addAttribute("lugares", lugaresRepository.findAll());
        model.addAttribute("personas", personaRepository.findAll());

        return "FormNuevoViaje";
    }
    @PostMapping("/guardarViaje")
    public String guardarDistribuidoras(Model model, Viajes viajes){
        i++;
        viajes.setIdViajes(i);
        viajesRepository.save(viajes);
        return "redirect:/ListarViajes";
    }


}
