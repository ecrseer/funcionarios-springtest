package br.gj.infnetat.gabjustino_funcionario_at.departamento;

import br.gj.infnetat.gabjustino_funcionario_at.funcionario.Funcionario;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String local;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;


    public Departamento(Long id, String nome, String local, List<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.funcionarios = funcionarios;
    }

    public Departamento() {
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
