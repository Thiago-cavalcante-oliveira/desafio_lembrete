package desfaio.Lembretes.Service;

import desfaio.Lembretes.Entidades.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {


    public Pessoa buscaNome(String nome) {

        return new Pessoa(1L, "Joao");
    }
}
