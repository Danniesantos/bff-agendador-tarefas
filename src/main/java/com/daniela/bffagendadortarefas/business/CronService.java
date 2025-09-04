package com.daniela.bffagendadortarefas.business;

import com.daniela.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);
        tarefasService.buscaTarefasAgendadasPorPeriodo(horaFutura, horaFuturaMaisCinco);
    }

    public String login(LoginRequestDTO loginDTO) {
        return usuarioService.loginUsuario(loginDTO);
    }

    public LoginRequestDTO converterParaRequestDTO() {
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }

}
