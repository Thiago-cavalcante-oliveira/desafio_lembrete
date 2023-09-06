package desfaio.Lembretes;

import desfaio.Lembretes.Controller.PessoaController;
import desfaio.Lembretes.DTO.PessoaDTO;
import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import desfaio.Lembretes.Service.PessoaService;

import org.junit.Assert;
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
        Pessoa pessoa = new Pessoa(1l, "Joao");
        Long id = 1l;
        Mockito.when(pessoaRepositorio.buscaNome("Joao")).thenReturn(pessoa);

        List<Pessoa> pessoas = new ArrayList<>();
pessoas.add(new Pessoa(1l, "Joao"));
pessoas.add(new Pessoa(2l, "Maria"));
pessoas.add(new Pessoa(3l, "Jose"));
        Mockito.when(pessoaRepositorio.findAll()).thenReturn(pessoas);
    }

//    @BeforeEach
//    void injectLista() {
//        List<Pessoa> pessoa = new ArrayList<>();
//pessoa.add(new Pessoa(1l, "Joao"));
//pessoa.add(new Pessoa(2l, "Maria"));
//pessoa.add(new Pessoa(3l, "Jose"));
//        Mockito.when(pessoaRepositorio.findAll()).thenReturn(pessoa);
//    }



    @Test
    public void testeControllerPessoaFindbyName() {
        var pessoa = pessoaController.retornaPessoa("Joaoss");
        Long id = pessoa.getBody().getId().longValue();
        Assert.assertEquals(1l, id, 0);
    }

    @Test
    public void testeControllerPessoaFindAll() {
        var pessoController = pessoaController.retornaLista();
        Assert.assertEquals(3, pessoController.getBody().size());
        }

        @Test
    public void testeControllerCadastro(){
                var pessoa = pessoaController.cadastraPessoa()
        }







}
