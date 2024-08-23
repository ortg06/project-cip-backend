package com.example.ProjectCIP.controller;

import com.example.ProjectCIP.service.ServicioService;
import com.example.ProjectCIP.service.UtilService;
import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/util")
public class UtilController {

    private final UtilService utilService;

    @Autowired
    public UtilController(UtilService utilService) {
        this.utilService = utilService;
    }
    @GetMapping("/s2DeptoWithMunicipio")
    public @ResponseBody
    S2Response s2POSData(S2Request s2Request) {
        return utilService.findAllDeptoWithMunicipios(s2Request);
    }
}
