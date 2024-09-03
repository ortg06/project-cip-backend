package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.utils.ServiceResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface FichaAdultoService {

    List<Persona> getAllPersona();

    List<Persona> getAllPersonaInscritas();

    List<Persona> getAllPersonaActivas();
    ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    ServiceResponse delete(Persona persona) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;

    ServiceResponse activar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

    ServiceResponse inactivar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
