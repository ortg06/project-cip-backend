package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.service.ServicioService;
import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    private final ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }


    @GetMapping("/s2")
    public @ResponseBody
    S2Response s2POSData(S2Request s2Request) {
        return servicioService.findAll(s2Request);
    }
}
