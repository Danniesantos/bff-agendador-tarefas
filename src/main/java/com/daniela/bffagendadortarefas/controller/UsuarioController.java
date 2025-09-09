package com.daniela.bffagendadortarefas.controller;

import com.daniela.bffagendadortarefas.business.UsuarioService;
import com.daniela.bffagendadortarefas.business.dto.in.EnderecoRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.TelefoneRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.in.UsuarioRequestDTO;
import com.daniela.bffagendadortarefas.business.dto.out.EnderecoResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.TelefoneResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.UsuarioResponseDTO;
import com.daniela.bffagendadortarefas.business.dto.out.ViaCepResponseDTO;
import com.daniela.bffagendadortarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "cadastro e login de usúarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario(@RequestBody UsuarioRequestDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login Usuários", description = " Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO loginDTO) {
        return usuarioService.loginUsuario(loginDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de Usuários por Email", description = "Buscar dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioResponseDTO> buscaUsuarioPorEmail(
            @RequestParam("email") String email,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar Usuários por Id", description = "Deleta um usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<Void> deletaUsuarioPorEmail(
            @PathVariable String email,
            @RequestHeader(value = "Authorization", required = false) String token) {
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar dados de Usuários", description = "Atualizar dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioResponseDTO> atualizaDadosUsuario(
            @RequestBody UsuarioRequestDTO usuarioDTO,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, usuarioDTO));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza Endereço de Usuários", description = "Atualiza endereço de Usuário")
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoResponseDTO> atualizaEndereco(
            @RequestBody EnderecoRequestDTO enderecoDTO,
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, enderecoDTO, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza Telefone de Usuários", description = "Atualiza telefone de Usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneResponseDTO> atualizaTelefone(
            @RequestBody TelefoneRequestDTO telefoneDTO,
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, telefoneDTO, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Salva Endereço de Usuários", description = "Salva endereço de Usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoResponseDTO> cadastraEndereco(
            @RequestBody EnderecoRequestDTO enderecoDTO,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraEndereco(enderecoDTO, token));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva Telefone de Usuários", description = "Salva telefone de Usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneResponseDTO> cadastraTelefone(
            @RequestBody TelefoneRequestDTO telefoneDTO,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastraTelefone(telefoneDTO, token));
    }

    @GetMapping("/endereco/{cep}")
    @Operation(summary = "Busca endereço pelo Cep", description = "Busca dados de endereço recebendo um cep")
    @ApiResponse(responseCode = "200", description = "Dados de endereço retornado com sucesso")
    @ApiResponse(responseCode = "400", description = "Cep inválido")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ViaCepResponseDTO> buscaEnderecoPorCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(usuarioService.buscaEnderecoPorCep(cep));
    }
}
