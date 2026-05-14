package model;

public class Turma {
    private int id;
    private int instituicaoId;
    private int professor;
    private String nome;
    private int anoLetivo;
    private String turno;
    private int vagas;

    public Turma(int id, int instituicaoId, int professor, String nome, int anoLetivo, String turno, int vagas) {
        this.id = id;
        this.instituicaoId = instituicaoId;
        this.professor = professor;
        this.nome = nome;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return String.format(
                "Turma: id= %d - nome= %s - ano-Letivo= %d - turno= %s - vagas= %d",
                id, nome, anoLetivo, turno, vagas
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public int getProfessor() {
        return professor;
    }

    public void setProfessor(int professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
