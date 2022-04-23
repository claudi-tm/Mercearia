package model;

import java.io.Serializable;
import java.util.UUID;

public class Pessoa implements Serializable {
    private final String id;
    private String nome;
    private String endereco;
    private String numeroTelefone;
    protected String email;
    protected int idade;
    private String sexo;

    

    protected final String nuit;

    public Pessoa(String nome, String email, String numeroTelefone, String nuit, int idade, String endereco, String sexo) {
        String uuid = UUID.randomUUID().toString(); 
        this.id = uuid.substring(0, uuid.length()/6);
        this.nome = nome.toLowerCase();
        this.email = email.toLowerCase();
        this.nuit = nuit.toLowerCase();
        this.idade = idade;
        this.endereco = endereco.toLowerCase();
        this.numeroTelefone = numeroTelefone;
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getnuit() {
        return nuit;
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
        return "ID: " + id + "\n" + "Nome: " + nome + "\n" + "Idade: " + idade + "\n" + "Numero de Tel: "
                + numeroTelefone + "\n" + "Endereço: " + endereco + "\n" + "Email: " + email;

    }

    public void setnuit(String nuit2) {
    }

}
