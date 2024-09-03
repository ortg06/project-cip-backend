package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.model.Pais;
import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.service.FichaAdultoService;
import com.example.ProjectCIP.service.GradoAcademicoService;
import com.example.ProjectCIP.utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/fichaAdulto")
public class FichaAdultoController {


    private final FichaAdultoService fichaAdultoService;

    @Autowired
    public FichaAdultoController(FichaAdultoService fichaAdultoService) {
        this.fichaAdultoService = fichaAdultoService;
    }

    @GetMapping("/dt")
    public List<Persona> getAllPersonaForDataTable() {
        return fichaAdultoService.getAllPersona();
    }

    @GetMapping("/dtInscritas")
    public List<Persona> getAllPersonaInscritasForDataTable() {
        return fichaAdultoService.getAllPersonaInscritas();
    }

    @GetMapping("/dtActivas")
    public List<Persona> getAllPersonaActivasForDataTable() {
        return fichaAdultoService.getAllPersonaActivas();
    }

    @PostMapping("/save")
    public @ResponseBody
    ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return fichaAdultoService.save(persona);
    }


    @PostMapping("/activar")
    public @ResponseBody
    ServiceResponse activar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return fichaAdultoService.activar(persona);
    }

    @PostMapping("/inactivar")
    public @ResponseBody
    ServiceResponse inactivar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return fichaAdultoService.inactivar(persona);
    }
}
