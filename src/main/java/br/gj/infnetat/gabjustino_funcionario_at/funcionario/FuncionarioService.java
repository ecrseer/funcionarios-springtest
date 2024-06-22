package br.gj.infnetat.gabjustino_funcionario_at.funcionario;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario encontrarPorId(Long id) throws BadRequestException {
        Optional<Funcionario> encontrado = funcionarioRepository.findById(id);
        if (encontrado.isPresent()) {
            return encontrado.get();
        } else {
            throw new BadRequestException("nao encontrado funcionario");
        }
    }

    public Funcionario removerPorId(Long id) throws BadRequestException {
        Funcionario encontrado = encontrarPorId(id);
        if (encontrado != null) {
            funcionarioRepository.deleteById(id);
            return encontrado;
        }
        return null;

    }
}
