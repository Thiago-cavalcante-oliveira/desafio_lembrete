package desfaio.Lembretes.Controller;

import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import desfaio.Lembretes.Service.PessoaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepositorio pessoaRepositorio;


    @GetMapping("/all")
        public ResponseEntity<List<Pessoa>> retornaLista () {
            List<Pessoa> pessoas = pessoaRepositorio.findAll();
            return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/nome")
    public ResponseEntity<Pessoa> retornaPessoa(@PathVariable("nome") final String nome ){
        try{
            return ResponseEntity.ok(pessoaService.buscaNome(nome));
        }
catch (RuntimeException e){
           return ResponseEntity.notFound().build();
}
    }


}
