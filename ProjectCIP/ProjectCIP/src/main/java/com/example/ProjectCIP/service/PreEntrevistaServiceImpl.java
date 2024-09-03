package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Estado;
import com.example.ProjectCIP.model.InfoAdicionalEntrevista;
import com.example.ProjectCIP.model.Persona;
import com.example.ProjectCIP.repository.EstadoRepository;
import com.example.ProjectCIP.repository.FichaAdultoRepository;
import com.example.ProjectCIP.repository.PreEntrevistaRepository;
import com.example.ProjectCIP.utils.Constants;
import com.example.ProjectCIP.utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Service
public class PreEntrevistaServiceImpl implements PreEntrevistaService{

    @Autowired
    private FichaAdultoRepository fichaAdultoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PreEntrevistaRepository preEntrevistaRepository;

    @Override
    public ServiceResponse savePreEntrevista(Persona persona) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceResponse serviceResponse = ServiceResponse.of(false);
        try {
            Optional<Estado> estado = estadoRepository.findById(1L);
            estado.ifPresent(persona::setEstado);
            InfoAdicionalEntrevista infoAdicionalEntrevista = preEntrevistaRepository.save(persona.getInfoAdicionalEntrevista());
            if(infoAdicionalEntrevista.getCodInfoAdicional() != null){
                persona.setOrigen("P"); //F: FORMULARIO  P: PRE ENTREVISTA
                Persona savedPersona = fichaAdultoRepository.save(persona);
                serviceResponse.setSuccess(true);
                serviceResponse.setMessage(Constants.MSG_GUARDADO);
                serviceResponse.setData(savedPersona);
                return serviceResponse;
            }else{
                serviceResponse.setSuccess(false);
                serviceResponse.setMessage("Ocurrio un Error al guardar, intente de nuevo o comuniquese con soporte");
                return serviceResponse;
            }
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Error al guardar la persona: "+e.getMessage());
            return serviceResponse;
        }
    }
}
