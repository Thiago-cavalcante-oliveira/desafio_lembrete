package desfaio.Lembretes.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_pessoa", schema = "public")
public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;



}
