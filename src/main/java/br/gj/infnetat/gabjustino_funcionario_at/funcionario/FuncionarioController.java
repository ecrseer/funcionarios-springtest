package br.gj.infnetat.gabjustino_funcionario_at.funcionario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.salvarFuncionario(funcionario);
    }

}
