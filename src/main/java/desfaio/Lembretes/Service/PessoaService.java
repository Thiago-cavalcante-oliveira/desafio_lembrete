package desfaio.Lembretes.Service;

import desfaio.Lembretes.DTO.PessoaDTO;
import desfaio.Lembretes.Entidades.Pessoa;
import desfaio.Lembretes.Repositorio.PessoaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    public Pessoa transformToEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        return pessoa;
    }

    public PessoaDTO transformToDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        return pessoaDTO;
    }

    public PessoaDTO buscaNome(String nome) {
        Pessoa pessoa = this.pessoaRepositorio.buscaNome(nome);

        return transformToDTO(pessoa);
    }

    @Transactional(rollbackOn = Exception.class)
    public String cadastraPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = transformToEntity(pessoaDTO);
        this.pessoaRepositorio.save(pessoa);
        return "CAdastrado com sucesso";
    }


    @Transactional(rollbackOn = Exception.class)
    public String atualizarPessoa(PessoaDTO pessoaDTO, Long id){
        Pessoa pessoa = transformToEntity(pessoaDTO);
        this.pessoaRepositorio.save(pessoa);
        return "Atualizado com sucesso";
    }

    @Transactional(rollbackOn = Exception.class)
    public String deletarPessoa(Long id){
      Optional<Pessoa> pessoa = this.pessoaRepositorio.findById(id);
        if(pessoa.isPresent()){
            this.pessoaRepositorio.deleteById(id);
            return "Deletado com sucesso";        }
    else{
        return "Não encontrado";
    }

}

}
