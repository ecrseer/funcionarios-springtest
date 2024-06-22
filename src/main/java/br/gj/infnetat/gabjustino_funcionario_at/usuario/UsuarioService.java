package br.gj.infnetat.gabjustino_funcionario_at.usuario;

import org.apache.coyote.BadRequestException;
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

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario encontrarPorNome(String nome) throws BadRequestException {
        try {
            List<Usuario> encontrados = usuarioRepository.findUsuarioByNome(nome);
            return encontrados.get(0);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

    }
}
