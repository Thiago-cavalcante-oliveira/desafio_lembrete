package desfaio.Lembretes.Service;

import desfaio.Lembretes.DTO.LembreteDTO;
import desfaio.Lembretes.Entidades.Lembretes;
import desfaio.Lembretes.Repositorio.LembreteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {

    @Autowired
    LembreteRepositorio lembreteRepositorio;

    public Lembretes transformToEntity(LembreteDTO lembreteDTO){
        Lembretes lembrete = new Lembretes();
        lembrete.setId(lembrete.getId());
        lembreteDTO.setLembrete(lembrete.getLembrete());
        lembreteDTO.setPessoa(lembrete.getPessoa());
        return lembrete;
    }

    public LembreteDTO transformToDTO(Lembretes lembrete){
        LembreteDTO lembreteDTO = new LembreteDTO();
        lembreteDTO.setId(lembrete.getId());
        lembreteDTO.setLembrete(lembrete.getLembrete());
        lembreteDTO.setPessoa(lembrete.getPessoa());
        return lembreteDTO;
    }

    public String cadastraLembrete(LembreteDTO lembreteDTO){
        Lembretes lembrete = transformToEntity(lembreteDTO);
        this.lembreteRepositorio.save(lembrete);
        return "Cadastrado com sucesso";
    }

    public LembreteDTO findById(Long id){
        Lembretes lembrete = this.lembreteRepositorio.findById(id).orElse(null);
        return transformToDTO(lembrete);
    }

    public List findAll(){

        List<Lembretes> lembretes = this.lembreteRepositorio.findAll();
        List<LembreteDTO> lembreteDTOS = null;

        for (Lembretes valor: lembretes
             ) {
            lembreteDTOS.add(transformToDTO(valor));
        }
        return lembreteDTOS;
    }

    public String atualizarLembrete(LembreteDTO lembreteDTO, Long id){
        Lembretes lembrete = transformToEntity(lembreteDTO);
        this.lembreteRepositorio.save(lembrete);
        return "Atualizado com sucesso";
    }

    public String deletarLembrete(Long id){
        this.lembreteRepositorio.deleteById(id);
        return "Deletado com sucesso";
    }


}
