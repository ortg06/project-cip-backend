package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Estado;
import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.repository.EstadoRepository;
import com.example.ProjectCIP.repository.FichaAdultoRepository;
import com.example.ProjectCIP.utils.Constants;
import com.example.ProjectCIP.utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class FichaAdultoServiceImpl implements FichaAdultoService{

    @Autowired
    private FichaAdultoRepository fichaAdultoRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public List<Persona> getAllPersona() {
        return fichaAdultoRepository.findAll();
    }

    @Override
    public ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceResponse serviceResponse = ServiceResponse.of(false);
        try {
            Optional<Estado> estado = estadoRepository.findById(1L);
            estado.ifPresent(persona::setEstado);
            Persona savedPersona = fichaAdultoRepository.save(persona);
            serviceResponse.setSuccess(true);
            serviceResponse.setMessage(Constants.MSG_GUARDADO);
            serviceResponse.setData(savedPersona);
            return serviceResponse;
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Error al guardar la persona: "+e.getMessage());
            return serviceResponse;
        }
    }

    @Override
    public ServiceResponse delete(Persona persona) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return null;
    }
}
