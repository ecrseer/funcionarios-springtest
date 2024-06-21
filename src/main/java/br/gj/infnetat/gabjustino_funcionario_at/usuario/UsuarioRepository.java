package br.gj.infnetat.gabjustino_funcionario_at.usuario;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    List<Usuario> findUsuarioByNome(String nome);
}
