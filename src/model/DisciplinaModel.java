package model;

/**
 *
 * @author José Orlando
 */
public class DisciplinaModel {
    private int id;
    private int idAreaConhecimento;
    private String nomeAreaConhecimento;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAreaConhecimento() {
        return nomeAreaConhecimento;
    }

    public void setNomeAreaConhecimento(String nomeAreaConhecimento) {
        this.nomeAreaConhecimento = nomeAreaConhecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAreaConhecimento() {
        return idAreaConhecimento;
    }

    public void setIdAreaConhecimento(int idAreaConhecimento) {
        this.idAreaConhecimento = idAreaConhecimento;
    }
    
}
