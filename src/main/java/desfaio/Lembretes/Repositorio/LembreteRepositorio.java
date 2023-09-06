package desfaio.Lembretes.Repositorio;

import desfaio.Lembretes.DTO.LembreteDTO;
import desfaio.Lembretes.Entidades.Lembretes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LembreteRepositorio extends JpaRepository<Lembretes, Long> {

    @Query("select lembrete from Lembretes lembrete where lembrete.pessoa.id = :pessoa")
    public List<Lembretes> listaLembretes(@RequestParam("pessoa") Long pessoa);
}
