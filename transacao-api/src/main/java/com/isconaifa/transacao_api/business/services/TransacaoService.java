package com.isconaifa.transacao_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isconaifa.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.isconaifa.transacao_api.infrastructure.exceptions.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {

        log.info("Iniciada o processo de gravar transacoes" +dto);

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que a data atual");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atual");
        }

        if (dto.valor() < 0) {
            log.error("Valores de transacoes menores que 0");
            throw new UnprocessableEntity("Os valores não podem ser menores que 0");
        }

        listaTransacoes.add(dto);
        log.info("Transações adicionadas com sucesso!");
    }

    public void limparTransacoes() {
        log.info("Iniciadas o processo para deleção de transações");
        listaTransacoes.clear();
        log.info("Transações deletada com sucesso!");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo))
                .toList();
    }
}