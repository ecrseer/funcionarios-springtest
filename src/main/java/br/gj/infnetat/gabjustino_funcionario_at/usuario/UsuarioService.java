package br.gj.infnetat.gabjustino_funcionario_at.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario encontrarPorNome(String nome) {
        try {
            List<Usuario> encontrados = usuarioRepository.findUsuarioByNome(nome);
            return encontrados.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}
