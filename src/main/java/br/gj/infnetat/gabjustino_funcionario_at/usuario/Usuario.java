package br.gj.infnetat.gabjustino_funcionario_at.usuario;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nome;
    private String email;

    public Usuario(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
