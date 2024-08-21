package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Pais;
import com.example.ProjectCIP.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }
}