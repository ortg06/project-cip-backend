package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.utils.ServiceResponse;

import java.lang.reflect.InvocationTargetException;

public interface PreEntrevistaService {

    ServiceResponse savePreEntrevista(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
