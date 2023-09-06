package desfaio.Lembretes;

import desfaio.Lembretes.Controller.LembreteController;
import desfaio.Lembretes.Controller.PessoaController;
import desfaio.Lembretes.DTO.PessoaDTO;
import desfaio.Lembretes.Entidades.Lembretes;
import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.LembreteRepositorio;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import desfaio.Lembretes.Service.LembreteService;
import desfaio.Lembretes.Service.PessoaService;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;


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

    @MockBean
    LembreteRepositorio lembreteRepositorio;
    @Autowired
    LembreteController lembreteController;
    @Autowired
    LembreteService lembreteService;

    @BeforeEach
    void injectDado() {
        Pessoa pessoa = new Pessoa(1l, "Joao");
        PessoaDTO pessoaDTO = new PessoaDTO(1l, "Joao");
        Long id = 1l;
        Mockito.when(pessoaRepositorio.buscaNome("Joao")).thenReturn(pessoa);
        Mockito.when(pessoaController.cadastraPessoa(pessoaDTO)).thenReturn(ResponseEntity.ok(
                "Cadastrado com sucesso"));

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1l, "Joao"));
        pessoas.add(new Pessoa(2l, "Maria"));
        pessoas.add(new Pessoa(3l, "Jose"));
        Mockito.when(pessoaRepositorio.findAll()).thenReturn(pessoas);
    }

    @BeforeEach
    void injectLembrete() {
        Pessoa pessoa = new Pessoa(1l, "Joao");
        Lembretes lembrete = new Lembretes(1l, "Lembrete", pessoa);
        Long id = 1l;
        Mockito.when(lembreteRepositorio.findById(id)).thenReturn(Optional.of(lembrete));

        List<Lembretes> lembretes = new ArrayList<>();
        lembretes.add(new Lembretes(1l, "Lembrete", pessoa));
        lembretes.add(new Lembretes(2l, "Lembrete2", pessoa));
        Mockito.when(lembreteRepositorio.listaLembretes(pessoa.getId())).thenReturn(lembretes);


    }

    @Test
    public void testeControllerPessoaFindbyName() {
        var pessoa = pessoaController.retornaPessoa("Joao");
        Long id = pessoa.getBody().getId().longValue();
        Assert.assertEquals(1l, id, 0);
    }

    @Test
    public void testeControllerPessoaFindAll() {
        var pessoController = pessoaController.retornaLista();
        Assert.assertEquals(3, pessoController.getBody().size());
    }

    @Test
    public void testeControllerCadastro() {
        var pessoa = pessoaController.cadastraPessoa(new PessoaDTO(1l, "Joao"));
        Assert.assertEquals("Cadastrado com sucesso", pessoa.getBody());
    }

    @Test
    public void testeDeletarPessoa() {
        var pessoa = pessoaController.deletaPessoa(1l);
        Assert.assertEquals("Deletado com sucesso", pessoa.getBody());
    }



}
