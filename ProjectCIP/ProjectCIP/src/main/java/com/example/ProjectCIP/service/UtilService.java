package com.example.ProjectCIP.service;


import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;

/*servicio para implementaciones de metodos que se ocupan de forma general o que tienen vinculados mas de una entidad*/
public interface UtilService {

    S2Response findAllDeptoWithMunicipios(S2Request s2Request);

}
