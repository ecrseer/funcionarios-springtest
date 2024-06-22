package br.gj.infnetat.gabjustino_funcionario_at.usuario;


import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public List<Usuario> resgatarTodosUsuarios() {
        return this.usuarioService.listar();
    }


}
