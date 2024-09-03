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
import java.time.LocalDate;
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
    public List<Persona> getAllPersonaInscritas() {
        return fichaAdultoRepository.findByEstado_CodigoEstado(1L);
    }

    @Override
    public List<Persona> getAllPersonaActivas() {
        return fichaAdultoRepository.findByEstado_CodigoEstadoAndEsPaciente(2L,"S");
    }

    @Override
    public ServiceResponse save(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceResponse serviceResponse = ServiceResponse.of(false);
        try {
            Optional<Estado> estado = estadoRepository.findById(1L);
            estado.ifPresent(persona::setEstado);
            persona.setOrigen("F");// F: FORMULARIO  P: PRE ENTREVISTA
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

    @Override
    public ServiceResponse activar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceResponse serviceResponse = ServiceResponse.of(false);
        if(persona.getEstado().getCodigoEstado().equals(1L)){
            try {
            Optional<Estado> estado = estadoRepository.findById(2L);
            estado.ifPresent(persona::setEstado);
            persona.setEsPaciente("S");
            persona.setPacienteDesde(LocalDate.now());
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
        }else{
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("La persona no se encuentra Activa, Favor verifique el estado de la persona");
            return serviceResponse;
        }
    }

    @Override
    public ServiceResponse inactivar(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceResponse serviceResponse = ServiceResponse.of(false);
        if(persona.getEstado().getCodigoEstado().equals(2L)){
            try {
                Optional<Estado> estado = estadoRepository.findById(3L);
                estado.ifPresent(persona::setEstado);
                persona.setFechaInactivo(LocalDate.now());
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
        }else{
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("La persona no se encuentra Activa, Favor verifique el estado de la persona");
            return serviceResponse;
        }
    }


}
