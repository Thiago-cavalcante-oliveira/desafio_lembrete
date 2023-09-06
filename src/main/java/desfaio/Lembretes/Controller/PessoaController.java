package desfaio.Lembretes.Controller;

import desfaio.Lembretes.DTO.PessoaDTO;
import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import desfaio.Lembretes.Service.PessoaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PessoaDTO> retornaPessoa(@PathVariable("nome") final String nome ){
        try{
            return ResponseEntity.ok(pessoaService.buscaNome(nome));
        }
catch (RuntimeException e){
           return ResponseEntity.notFound().build();
}
    }

    @PostMapping
    public ResponseEntity<String> cadastraPessoa(@RequestBody PessoaDTO pessoa){
        try{
            return ResponseEntity.ok(pessoaService.cadastraPessoa(pessoa));
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizaPessoa(@RequestBody PessoaDTO pessoa, @PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(pessoaService.atualizarPessoa(pessoa, id));
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaPessoa(@PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(pessoaService.deletarPessoa(id));
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


}
