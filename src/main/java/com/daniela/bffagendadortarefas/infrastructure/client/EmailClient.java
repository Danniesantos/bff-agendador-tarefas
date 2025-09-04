package com.daniela.bffagendadortarefas.infrastructure.client;

import com.daniela.bffagendadortarefas.business.dto.out.TarefasResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasResponseDTO tarefasDTO);


}
