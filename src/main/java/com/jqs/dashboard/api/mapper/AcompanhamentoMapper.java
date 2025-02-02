package com.jqs.dashboard.api.mapper;


import com.jqs.dashboard.api.dto.AcompanhamentoDto2;
import com.jqs.dashboard.api.entity.Acompanhamento;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AcompanhamentoMapper {

    private final ModelMapper modelMapper;

    public AcompanhamentoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AcompanhamentoDto2 acompanhamentoToDto(Acompanhamento entity){
        return modelMapper.map(entity, AcompanhamentoDto2.class);
    }
}
