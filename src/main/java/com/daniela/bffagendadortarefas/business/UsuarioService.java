package com.daniela.bffagendadortarefas.business;

import com.daniela.bffagendadortarefas.business.dto.in.EnderecoRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.TelefoneRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.UsuarioRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.out.EnderecoResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.TelefoneResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.UsuarioResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.ViaCepResponseDTO;
import com.daniela.bffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient client;

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO loginDTO) {
        return client.login(loginDTO);
    }

    public UsuarioResponseDTO buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioResponseDTO atualizaDadosUsuario(String token, UsuarioRequestDTO usuarioDTO) {
        return client.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoResponseDTO atualizaEndereco(Long idEndereco, EnderecoRequestDTO enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneResponseDTO atualizaTelefone(Long idTelefone, TelefoneRequestDTO telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);

    }

    public EnderecoResponseDTO cadastraEndereco(EnderecoRequestDTO enderecoDTO, String token) {

        return client.cadastraEndereco(enderecoDTO, token);

    }

    public TelefoneResponseDTO cadastraTelefone(TelefoneRequestDTO telefoneDTO, String token) {

        return client.cadastraTelefone(telefoneDTO, token);
    }

    public ViaCepResponseDTO buscaEnderecoPorCep(String cep) {
        return client.buscaDadosCep(cep);
    }
}
