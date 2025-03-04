package com.isconaifa.transacao_api.business.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isconaifa.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.isconaifa.transacao_api.controller.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticaTransacoes(Integer intervaloBusca) {
        log.info("Iniciada busca de estatisticas de transações");
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

if(transacoes.isEmpty()){
return new EstatisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
}

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
                log.info("Estatisticas retornadas com sucesso!");
        return new EstatisticasResponseDTO(
                estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }

}