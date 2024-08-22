package com.example.ProjectCIP.service;


import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;

public interface ServicioService {

    S2Response findAll(S2Request s2Request);
    S2Response findAllVigentes(S2Request s2Request);
}
