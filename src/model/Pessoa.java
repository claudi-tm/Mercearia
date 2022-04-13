package model;

import java.io.Serializable;
import java.util.UUID;
import java.util.Vector;

public class Pessoa implements Serializable{
    private final String id;
    private String nome;
    private String endereco;

   

    private String numeroTelefone;
    protected String email;
    protected int idade;

   

	protected final String NUIT;

    public Pessoa(String nome, String email, String numeroTelefone, String NUIT, int idade, String endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.NUIT = NUIT;
        this.idade = idade;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
    }

     public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNUIT() {
		return NUIT;
	}

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return this.id;
    }

    

    @Override
    public String toString() {
        return "Pessoa [endereco=" + endereco + ", id=" + id + ", nome=" + nome + ", numeroTelefone=" + numeroTelefone
                + "]";
    }

}
