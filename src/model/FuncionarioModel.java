package model;

/**
 *
 * @author José Orlando
 */
public class FuncionarioModel {
    private int id;
    private String nome;
    private String cargo;
    private String login;
    private String senha;
    private Object leciona;
    private Object coordena;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public Object getLeciona() {
        return  leciona;
    }
    
    
    public void setLeciona(Object leciona) {
        this.leciona = leciona;
    }

    public Object getCoordena() {
        return coordena;
    }

    public void setCoordena(Object coordena) {
        this.coordena = coordena;
    }
}
