package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.model.Pais;
import com.example.ProjectCIP.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/dt")
    public List<Pais> getAllPaisesForDataTable() {
        return paisService.getAllPaises();
    }
}