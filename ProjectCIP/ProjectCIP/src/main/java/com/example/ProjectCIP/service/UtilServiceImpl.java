package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Departamento;
import com.example.ProjectCIP.model.Municipio;
import com.example.ProjectCIP.repository.DepartamentoRepository;
import com.example.ProjectCIP.repository.MunicipioRepository;
import com.example.ProjectCIP.utils.select2.S2;
import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UtilServiceImpl implements UtilService{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private MunicipioRepository municipioRepository;

   /* @Override
    public S2Response findAllDeptoWithMunicipios(S2Request s2Request) {
        // Recuperar todos los departamentos y municipios
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<Municipio> municipios = municipioRepository.findAll();

        // Mapear municipios por departamento
        Map<Departamento, List<Municipio>> municipiosPorDepartamento = municipios.stream()
                .collect(Collectors.groupingBy(Municipio::getDepartamento));

        // Crear la estructura de respuesta
        List<S2> s2Content = new ArrayList<>();

        for (Departamento departamento : departamentos) {
            // Crear las opciones para los municipios del departamento
            List<S2> options = municipiosPorDepartamento.getOrDefault(departamento, List.of()).stream()
                    .map(municipio -> new S2(municipio.getCodMunicipio().toString(), municipio.getNombreMunicipio(), null))
                    .collect(Collectors.toList());

            // Crear el optgroup para el departamento
            S2 optGroup = new S2(departamento.getCodigoDepartamento().toString(), departamento.getNombreDepartamento(), (Serializable) options);
            s2Content.add(optGroup);
        }

        // Crear y retornar la respuesta
        return S2Response.of(s2Content, S2Response.Pagination.hasMore(false));
    }
*/
    @Override
    public S2Response findAllDeptoWithMunicipios(S2Request s2Request) {
        // Recuperar todos los departamentos y municipios con paginación si es necesario
        Page<Departamento> departamentosPage = departamentoRepository.findAll(PageRequest.of(s2Request.getPage() - 1, s2Request.getRows()));
        Page<Municipio> municipiosPage = municipioRepository.findAll(PageRequest.of(s2Request.getPage() - 1, s2Request.getRows()));

        // Convertir el contenido a listas
        List<Departamento> departamentos = departamentosPage.getContent();
        List<Municipio> municipios = municipiosPage.getContent();

        // Agrupar municipios por departamento
        Map<Departamento, List<Municipio>> municipiosPorDepartamento = municipios.stream()
                .collect(Collectors.groupingBy(Municipio::getDepartamento));

        // Crear la lista de `S2` para la respuesta
        List<S2> s2Content = departamentos.stream()
                .map(departamento -> {
                    // Crear las opciones para los municipios del departamento
                    List<S2> opcionesMunicipios = municipiosPorDepartamento.getOrDefault(departamento, List.of()).stream()
                            .map(municipio -> new S2(municipio.getCodMunicipio().toString(), municipio.getNombreMunicipio(), null))
                            .collect(Collectors.toList());

                    // Crear el `S2` para el departamento, con `children` como lista de municipios
                    return new S2(departamento.getCodigoDepartamento().toString(), departamento.getNombreDepartamento(), (Serializable) opcionesMunicipios);
                })
                .collect(Collectors.toList());

        // Devolver la respuesta con paginación
        return S2Response.of(s2Content, S2Response.Pagination.hasMore(departamentosPage.hasNext() || municipiosPage.hasNext()));
    }
}
