package model;

/**
 *
 * @author José Orlando
 */
public class AlunoModel {

    
    private int id;
    private String nome;
    private int classeId;
    private String login;
    private String senha;
    private int ano;
    private char turma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public char getTurma() {
        return turma;
    }

    public void setTurma(char turma) {
        this.turma = turma;
    }
    
}
