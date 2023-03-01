package model;

/**
 *
 * @author José Orlando
 */
public class LoginModel {

    private String nome;
    private int id;
    private int idClasse;
    private String login;
    private String senha;
    private String cargo;
    private String leciona;
    private String coordena;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getLeciona() {
        return leciona;
    }

    public void setLeciona(String leciona) {
        this.leciona = leciona;
    }

    public String getCoordena() {
        return coordena;
    }

    public void setCoordena(String coordena) {
        this.coordena = coordena;
    }

}
