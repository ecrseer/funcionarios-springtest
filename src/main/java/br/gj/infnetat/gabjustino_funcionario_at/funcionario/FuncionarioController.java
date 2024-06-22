package br.gj.infnetat.gabjustino_funcionario_at.funcionario;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> encontraTodosFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        Funcionario salvo = this.funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(salvo);
    }

}
