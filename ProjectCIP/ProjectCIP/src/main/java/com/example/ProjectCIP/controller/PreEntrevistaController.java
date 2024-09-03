package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.service.PreEntrevistaService;
import com.example.ProjectCIP.utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/preEntrevista")
public class PreEntrevistaController {

    private final PreEntrevistaService preEntrevistaService;

    @Autowired
    public PreEntrevistaController(PreEntrevistaService preEntrevistaService) {
        this.preEntrevistaService = preEntrevistaService;
    }

    @PostMapping("/save")
    public @ResponseBody
    ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return preEntrevistaService.savePreEntrevista(persona);
    }
}
