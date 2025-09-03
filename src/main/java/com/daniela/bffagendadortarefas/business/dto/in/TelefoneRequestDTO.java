package com.daniela.bffagendadortarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneRequestDTO {

    private String numero;
    private String ddd;
}
