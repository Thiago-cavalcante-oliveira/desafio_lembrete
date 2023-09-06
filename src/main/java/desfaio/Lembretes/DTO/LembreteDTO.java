package desfaio.Lembretes.DTO;

import desfaio.Lembretes.Entidades.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LembreteDTO {

    private Long id;
    private String lembrete;
    private Pessoa pessoa;

}
