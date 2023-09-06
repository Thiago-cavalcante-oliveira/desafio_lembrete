package desfaio.Lembretes.Repositorio;

import desfaio.Lembretes.Entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

    @Query("select pessoa from Pessoa pessoa where pessoa.nome = :nome")
    public Pessoa buscaNome(@PathVariable final String nome);

    Pessoa findByNome(String nome);

}
