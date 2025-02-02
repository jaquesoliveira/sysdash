package com.jqs.dashboard.api.service;

import com.jqs.dashboard.api.dto.AcompanhamentoDto;
import com.jqs.dashboard.api.dto.AcompanhamentoDto2;
import com.jqs.dashboard.api.dto.AcompanhamentoRSDto;
import com.jqs.dashboard.api.dto.UsuarioDto;
import com.jqs.dashboard.api.entity.Acompanhamento;
import com.jqs.dashboard.api.entity.Usuario;
import com.jqs.dashboard.api.repository.AcompanhamentoRepository;
import com.jqs.dashboard.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AcompanhamentoService {

    private final AcompanhamentoRepository repository;

    private final UsuarioRepository usuarioRepository;

    public void salvar(AcompanhamentoDto dto, String userName){

        var usuarioLogado = usuarioRepository.findByUsername(userName).get();
        var acompanhamento = new Acompanhamento(dto.tipo(), usuarioLogado);
        acompanhamento.setData(LocalDate.now());

        repository.save(acompanhamento);
    }

    public List<AcompanhamentoDto2> listar(){

        return repository.findAll().stream()
                .map((item) -> {
                    return new AcompanhamentoDto2(item.getTipo(),
                            new UsuarioDto(item.getUsuario().getUsername()) );
                }).collect(Collectors.toList());
    }

    public Optional<Acompanhamento> finaById(final Long id){
        return repository.findById(id);
    }

    public List<AcompanhamentoRSDto> finaByName(final String userName){

        return repository.findByName(userName).stream()
            .map((item) -> {
                return new AcompanhamentoRSDto(item.getUsuario(), item.getProspect(), item.getContato(), item.getQualificado());
            }).collect(Collectors.toList());
    }
}
