package com.daniela.bffagendadortarefas.business;

import com.daniela.bffagendadortarefas.business.dto.in.TarefasRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.out.TarefasResponseDTO;
import com.daniela.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import com.daniela.bffagendadortarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasResponseDTO gravarTarefa(String token, TarefasRequestDTO tarefasDTO) {
        return tarefasClient.gravarTarefas(tarefasDTO, token);
    }

    public List<TarefasResponseDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasResponseDTO> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasResponseDTO alteraStatusNotificacao(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasResponseDTO updateTarefas(TarefasRequestDTO tarefasDTO, String id, String token) {
        return tarefasClient.updateTarefas(tarefasDTO, id, token);
    }
}

