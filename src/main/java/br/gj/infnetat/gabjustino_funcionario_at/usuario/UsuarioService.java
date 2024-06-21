package br.gj.infnetat.gabjustino_funcionario_at.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario encontrarPorNome(String nome) {
        return usuarioRepository.findUsuarioByNome(nome);
    }
}
