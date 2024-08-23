package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.Servicio;
import com.example.ProjectCIP.repository.ServicioRepository;
import com.example.ProjectCIP.utils.select2.S2;
import com.example.ProjectCIP.utils.select2.S2Request;
import com.example.ProjectCIP.utils.select2.S2Response;
import com.example.ProjectCIP.utils.specificationbuilder.GenericSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioRepository servicioRepository;


    @Override
    public S2Response findAll(S2Request s2Request) {
        GenericSpecificationBuilder<Servicio> spBuilder = GenericSpecificationBuilder
                .of(Servicio.class);
        if (s2Request.getQ() != null && !s2Request.getQ().isEmpty()) {
            spBuilder = spBuilder.or().like("descripcion", s2Request.getQ());
        }
        Specification<Servicio> specification = Specification.where(spBuilder.build());
        Slice<Servicio> data = servicioRepository.findAll(specification, PageRequest.of(s2Request.getPage() - 1, s2Request.getRows()));
        List<S2> s2content = data.map(servicio -> new S2(servicio.getCodServicio().toString(),servicio.getDescripcion(), servicio)).getContent();
        return S2Response.of(s2content, S2Response.Pagination.hasMore(data.hasNext()));
    }

    @Override
    public S2Response findAllVigentes(S2Request s2Request) {
        return null;
    }

}
