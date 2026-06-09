package br.com.ecoorbit.model;

public class AreaMonitorada {

    private int id;
    private String nome;
    private String cidade;
    private String estado;
    private double tamanhoHectares;
    private int usuarioId;

    public AreaMonitorada() {
    }

    public AreaMonitorada(int id, String nome, String cidade, String estado, double tamanhoHectares, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.tamanhoHectares = tamanhoHectares;
        this.usuarioId = usuarioId;
    }

    public AreaMonitorada(String nome, String cidade, String estado, double tamanhoHectares, int usuarioId) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.tamanhoHectares = tamanhoHectares;
        this.usuarioId = usuarioId;
    }

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


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public double getTamanhoHectares() {
        return tamanhoHectares;
    }

    public void setTamanhoHectares(double tamanhoHectares) {
        this.tamanhoHectares = tamanhoHectares;
    }


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "AreaMonitorada{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", tamanhoHectares=" + tamanhoHectares +
                ", usuarioId=" + usuarioId +
                '}';
    }
}