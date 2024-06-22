package br.gj.infnetat.gabjustino_funcionario_at;


import br.gj.infnetat.gabjustino_funcionario_at.funcionario.Funcionario;
import br.gj.infnetat.gabjustino_funcionario_at.funcionario.FuncionarioService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class FuncionarioServiceTests {

    @Autowired
    private FuncionarioService funcionarioService;


    @Test
    public void testaEditarFuncionario() {
        Funcionario funcionario = new Funcionario("Gabri");
        Funcionario salvo = funcionarioService.salvarFuncionario(funcionario);
        salvo.setNome("Rafa");
        Funcionario editado = funcionarioService.salvarFuncionario(salvo);
        assertSame("Rafa", editado.getNome());
    }

    @Test
    public void testaDeletarFuncionario() throws BadRequestException {
        Funcionario funcionario = new Funcionario("Gabri");
        Funcionario salvo = funcionarioService.salvarFuncionario(funcionario);
        assertSame("Gabri", salvo.getNome());
        List<Funcionario> lista = funcionarioService.listarFuncionarios();
        assertEquals(1, lista.size());

        Funcionario removido = funcionarioService.removerPorId(salvo.getId());
        List<Funcionario> lista2 = funcionarioService.listarFuncionarios();
        assertEquals(0, lista2.size());
    }

    @Test
    public void testaCadastrarFuncionario() {
//        Funcionario funcionario = new Funcionario("Gabri");
//        Funcionario salvo = funcionarioService.salvarFuncionario(funcionario);
//        assertSame("Gabri", salvo.getNome());
//        List<Funcionario> lista = funcionarioService.listarFuncionarios();
//        assertEquals(1, lista.size());
    }
}
