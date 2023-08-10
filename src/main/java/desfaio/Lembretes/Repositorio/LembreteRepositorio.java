package desfaio.Lembretes.Repositorio;

import desfaio.Lembretes.Entidades.Lembretes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepositorio extends JpaRepository<Lembretes, Long> {
}
