package com.daniela.bffagendadortarefas.infrastructure.client;

import com.daniela.bffagendadortarefas.business.dto.in.EnderecoRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.TelefoneRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.UsuarioRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.out.EnderecoResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.TelefoneResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioResponseDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioResponseDTO salvaUsuario(@RequestBody UsuarioRequestDTO usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);


    @PutMapping
    UsuarioResponseDTO atualizaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioDTO,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoResponseDTO atualizaEndereco(@RequestBody EnderecoRequestDTO enderecoDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);


    @PutMapping("/telefone")
    TelefoneResponseDTO atualizaTelefone(@RequestBody TelefoneRequestDTO telefoneDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoResponseDTO cadastraEndereco(@RequestBody EnderecoRequestDTO enderecoDTO,
                                         @RequestHeader("Authorization") String token);


    @PostMapping("/telefone")
    TelefoneResponseDTO cadastraTelefone(@RequestBody TelefoneRequestDTO telefoneDTO,
                                         @RequestHeader("Authorization") String token);

}
