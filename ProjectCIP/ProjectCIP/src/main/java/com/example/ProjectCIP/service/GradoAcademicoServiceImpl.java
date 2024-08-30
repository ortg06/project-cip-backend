package com.example.ProjectCIP.service;

import com.example.ProjectCIP.model.GradoAcademico;
import com.example.ProjectCIP.repository.GradoAcademicoRepository;
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
public class GradoAcademicoServiceImpl implements GradoAcademicoService{


    @Autowired
    private GradoAcademicoRepository gradoAcademicoRepository;
    @Override
    public S2Response findAll(S2Request s2Request) {
        GenericSpecificationBuilder<GradoAcademico> spBuilder = GenericSpecificationBuilder
                .of(GradoAcademico.class);
        if (s2Request.getQ() != null && !s2Request.getQ().isEmpty()) {
            spBuilder = spBuilder.or().like("descripcion", s2Request.getQ());
        }
        Specification<GradoAcademico> specification = Specification.where(spBuilder.build());
        Slice<GradoAcademico> data = gradoAcademicoRepository.findAll(specification, PageRequest.of(s2Request.getPage() - 1, s2Request.getRows()));
        List<S2> s2content = data.map(gradoAcademico -> new S2(gradoAcademico.getCodigoGrado().toString(),gradoAcademico.getDescripcion(), gradoAcademico)).getContent();
        return S2Response.of(s2content, S2Response.Pagination.hasMore(data.hasNext()));
    }

}
