package com.example.ProjectCIP.service;

import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;

public interface GradoAcademicoService {

    S2Response findAll(S2Request s2Request);
}
