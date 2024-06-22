package br.gj.infnetat.gabjustino_funcionario_at;


import br.gj.infnetat.gabjustino_funcionario_at.funcionario.Funcionario;
import br.gj.infnetat.gabjustino_funcionario_at.funcionario.FuncionarioController;
import br.gj.infnetat.gabjustino_funcionario_at.funcionario.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FuncionarioController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TestaFuncionariosController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionarioService funcionarioService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testaSalvar() throws Exception {
        Funcionario mockFuncionario = new Funcionario("Gabri");
        salvaFuncionarioFalso(mockFuncionario).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        salvaFuncionarioFalso(new Funcionario()).andExpect(status().isBadRequest());
    }

    @Test
    void testaListar() throws Exception {

        mockMvc.perform(
                get("/funcionarios")
        ).andDo(print()).andExpect(status().isOk());
    }

    private ResultActions salvaFuncionarioFalso(Funcionario funcionario) throws Exception {
        return mockMvc.perform(
                post("/funcionarios")
                        .with(httpBasic("gabri", "123"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(funcionario))
        );
    }
}
