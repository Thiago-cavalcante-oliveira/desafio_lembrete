package desfaio.Lembretes.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="tb_pessoa", schema = "public")
public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;


    public Pessoa(long l, String joao) {
    }
}
