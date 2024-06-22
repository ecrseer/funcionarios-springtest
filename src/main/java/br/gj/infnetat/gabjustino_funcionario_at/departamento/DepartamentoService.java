package br.gj.infnetat.gabjustino_funcionario_at.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        departamentoRepository.deleteById(id);
    }

}
