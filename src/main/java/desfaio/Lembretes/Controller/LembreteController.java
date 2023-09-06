package desfaio.Lembretes.Controller;

import desfaio.Lembretes.DTO.LembreteDTO;
import desfaio.Lembretes.Service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LembreteController {

    @Autowired
private LembreteService lembreteService;

    @GetMapping("/id")
    public ResponseEntity<LembreteDTO> findById(@RequestParam("id") final Long id){
        try{
            return ResponseEntity.ok(lembreteService.findById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<LembreteDTO>> findAll(){
        try{
            return ResponseEntity.ok(lembreteService.findAll());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastraLembrete(@RequestBody final LembreteDTO lembreteDTO){
        try{
            return ResponseEntity.ok(lembreteService.cadastraLembrete(lembreteDTO));
        }
catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizaBilhetes(@RequestBody final LembreteDTO lembreteDTO, @PathVariable("id") final Long id){
        try{
            return ResponseEntity.ok(lembreteService.atualizarLembrete(lembreteDTO, id));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable ("id") final Long id){
        try{
            return ResponseEntity.ok(lembreteService.deletarLembrete(id));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
