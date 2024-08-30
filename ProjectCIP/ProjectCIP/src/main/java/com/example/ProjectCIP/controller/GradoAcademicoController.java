package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.service.GradoAcademicoService;
import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gradoAcademico")
public class GradoAcademicoController {

    private final GradoAcademicoService gradoAcademicoService;

    @Autowired
    public GradoAcademicoController(GradoAcademicoService gradoAcademicoService) {
        this.gradoAcademicoService = gradoAcademicoService;
    }


    @GetMapping("/s2")
    public @ResponseBody
    S2Response s2POSData(S2Request s2Request) {
        return gradoAcademicoService.findAll(s2Request);
    }
}
