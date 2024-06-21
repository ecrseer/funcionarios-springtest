package br.gj.infnetat.gabjustino_funcionario_at.usuario;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Usuario findUsuarioByNome(String nome);
}
