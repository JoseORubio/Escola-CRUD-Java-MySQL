package model;

/**
 *
 * @author José Orlando
 */
public class AvaliacaoModel {

    private String nomeProfessor;
    private int idProfessor;
    private String nomeAluno;
    private int idAluno;
    
    private String disciplina;
    private int ano;
    private String turma;

    private double bim1;
    private double bim2;
    private double bim3;
    private double bim4;

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public double getBim1() {
        return bim1;
    }

    public void setBim1(double bim1) {
        this.bim1 = bim1;
    }

    public double getBim2() {
        return bim2;
    }

    public void setBim2(double bim2) {
        this.bim2 = bim2;
    }

    public double getBim3() {
        return bim3;
    }

    public void setBim3(double bim3) {
        this.bim3 = bim3;
    }

    public double getBim4() {
        return bim4;
    }

    public void setBim4(double bim4) {
        this.bim4 = bim4;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
