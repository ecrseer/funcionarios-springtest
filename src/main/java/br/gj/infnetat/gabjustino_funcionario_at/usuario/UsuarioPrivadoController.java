package br.gj.infnetat.gabjustino_funcionario_at.usuario;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/usuarios/")
public class UsuarioPrivadoController {
    private UsuarioService usuarioService;

    public UsuarioPrivadoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/encontrar-por")
    public Usuario pesquisaUsuariosPorNome(@RequestParam String nome) throws BadRequestException {
        return this.usuarioService.encontrarPorNome(nome);
    }

}
