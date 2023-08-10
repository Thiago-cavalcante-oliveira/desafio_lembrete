package desfaio.Lembretes.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="tb_lembretes", schema = "public")
public class Lembretes {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter @Setter
    private String lembrete;


}
