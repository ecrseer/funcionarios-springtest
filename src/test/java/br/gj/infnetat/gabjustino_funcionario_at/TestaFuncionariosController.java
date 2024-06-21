package br.gj.infnetat.gabjustino_funcionario_at;

import br.gj.infnetat.gabjustino_funcionario_at.funcionario.Funcionario;
import br.gj.infnetat.gabjustino_funcionario_at.funcionario.FuncionarioController;
import br.gj.infnetat.gabjustino_funcionario_at.funcionario.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestaFuncionariosController {

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @BeforeEach
    public void setUp() {
        System.out.println("Iniciando TestaFuncionariosController");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testaSalvar(){
        Funcionario mockFuncionario = new Funcionario("Gabri");
        when(funcionarioController.save(mockFuncionario)).thenReturn(new Funcionario());
        Funcionario respostaController = funcionarioController.save(mockFuncionario);
        assertEquals(respostaController.getNome(), mockFuncionario.getNome());

    }
}
