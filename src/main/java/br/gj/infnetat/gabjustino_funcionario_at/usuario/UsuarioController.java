package br.gj.infnetat.gabjustino_funcionario_at.usuario;


import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastra")
    public Usuario cadastra(@RequestBody Usuario user){
        return this.usuarioService.salvar(user);
    }

    @GetMapping("/encontrar-por")
    public Usuario pesquisaUsuariosPorNome(@RequestParam String nome) throws BadRequestException {
        return this.usuarioService.encontrarPorNome(nome);
    }
}
