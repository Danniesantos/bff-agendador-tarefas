package com.daniela.bffagendadortarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneResponseDTO {

    private Long id;
    private String numero;
    private String ddd;
}
