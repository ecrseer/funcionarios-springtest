package br.gj.infnetat.gabjustino_funcionario_at.funcionario;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
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
        if (funcionario.getNome() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(funcionario);
        }
        Funcionario salvo = this.funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(salvo);
    }

    @PatchMapping
    public ResponseEntity<Funcionario> editarFuncionario(@RequestBody Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getId() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(funcionario);
        }
        Funcionario salvo = this.funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(salvo);
    }

    @DeleteMapping("por-id")
    public ResponseEntity<Funcionario> deletarFuncionario(@RequestParam Long idFuncionario) {
        try {
            Funcionario removido = funcionarioService.removerPorId(idFuncionario);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(removido);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
