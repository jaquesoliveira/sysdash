package com.jqs.dashboard.api.repository;

import com.jqs.dashboard.api.dto.AcompanhamentoRSDto;
import com.jqs.dashboard.api.entity.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {

    @Query(value = "SELECT ua.user_name as usuario,  " +
            " ( select count(acomp.tipo)  " +
            " from public.tb_acompanhamento acomp  " +
            " left join public.tb_usuario_acompanhamento u on acomp.usuario = u.id " +
            " where acomp.tipo = 'PROSPECT'  " +
            " and u.user_name = :name " +
            " ) as prospect, " +
            "  " +
            " ( select count(tipo)  " +
            " from public.tb_acompanhamento acomp " +
            " left join public.tb_usuario_acompanhamento ua on acomp.usuario = ua.id " +
            " where acomp.tipo = 'CONTATO'   " +
            " and ua.user_name = :name " +
            " ) as contato, " +
            "  " +
            " ( " +
            " select count(tipo)  " +
            " from public.tb_acompanhamento acomp  " +
            " left join public.tb_usuario_acompanhamento ua on acomp.usuario = ua.id " +
            " where acomp.tipo = 'QUALIFICADO'   " +
            " and ua.user_name = :name " +
            " ) as qualificado " +
            "  " +
            " FROM public.tb_acompanhamento acomp " +
            " left join public.tb_usuario_acompanhamento ua on acomp.usuario = ua.id " +
            " WHERE ua.user_name = :name " +
            "GROUP BY ua.user_name;", nativeQuery = true)
    List<AcompanhamentoRSDto> findByName(String name);
}
