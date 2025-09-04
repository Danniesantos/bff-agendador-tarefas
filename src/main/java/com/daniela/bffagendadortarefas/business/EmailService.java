package com.daniela.bffagendadortarefas.business;

import com.daniela.bffagendadortarefas.business.dto.out.TarefasResponseDTO;
import com.daniela.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasResponseDTO tarefasDTO) {

        emailClient.enviarEmail(tarefasDTO);
    }
}
