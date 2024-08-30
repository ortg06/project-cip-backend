package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.utils.ServiceResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface FichaAdultoService {

    List<Persona> getAllPersona();
    ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    ServiceResponse delete(Persona persona) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
