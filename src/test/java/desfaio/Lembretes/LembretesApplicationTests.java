package desfaio.Lembretes;

import desfaio.Lembretes.Controller.PessoaController;
import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import desfaio.Lembretes.Service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class LembretesApplicationTests {

    @MockBean
    PessoaRepositorio pessoaRepositorio;

    @Autowired
    PessoaController pessoaController;
    @Autowired
    PessoaService pessoaService;

    @BeforeEach
    void injectDado() {
        Optional<Pessoa> pessoa = Optional.of(new Pessoa(1l, "Joao"));
        Long id = 1l;
        Mockito.when(pessoaRepositorio.findById(id)).thenReturn(pessoa);
    }

    @BeforeEach
    void injectLista() {
        List<Pessoa> pessoa = new ArrayList<>();
pessoa.add(new Pessoa(1l, "Joao"));
pessoa.add(new Pessoa(2l, "Maria"));
pessoa.add(new Pessoa(3l, "Jose"));
        Mockito.when(pessoaRepositorio.findAll()).thenReturn(pessoa);
    }



    @Test
    public void testeControllerPessoaFindbyName() {
        var pessoController = pessoaController.retornaPessoa("Joao");
        Long id = pessoController.getBody().getId().longValue();
        Assertions.assertEquals(1l, id, 0);
    }

    @Test
    public void testeControllerPessoaFindAll() {
        var pessoController = pessoaController.retornaLista();
        Assertions.assertEquals(3, pessoController.getBody().size());
        }







}
