package br.gj.infnetat.gabjustino_funcionario_at.departamento;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departamentos")
public class DepartamentoController {
    private DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.listar();
    }

    @PostMapping
    public Departamento salvarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }

    @PatchMapping
    public Departamento atualizarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }

    @DeleteMapping
    public boolean excluirDepartamento(@RequestParam Long idDepartamento) {
        departamentoService.excluir(idDepartamento);
        return true;
    }

}
