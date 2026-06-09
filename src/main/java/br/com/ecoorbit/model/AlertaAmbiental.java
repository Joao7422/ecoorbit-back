package br.com.ecoorbit.model;

import java.time.LocalDate;

public class AlertaAmbiental {

    private int id;
    private String tipo;
    private String nivelRisco;
    private String descricao;
    private LocalDate dataAlerta;
    private int areaId;

    public AlertaAmbiental() {
    }

    public AlertaAmbiental(int id, String tipo, String nivelRisco, String descricao, LocalDate dataAlerta, int areaId) {
        this.id = id;
        this.tipo = tipo;
        this.nivelRisco = nivelRisco;
        this.descricao = descricao;
        this.dataAlerta = dataAlerta;
        this.areaId = areaId;
    }

    public AlertaAmbiental(String tipo, String nivelRisco, String descricao, LocalDate dataAlerta, int areaId) {
        this.tipo = tipo;
        this.nivelRisco = nivelRisco;
        this.descricao = descricao;
        this.dataAlerta = dataAlerta;
        this.areaId = areaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNivelRisco() {
        return nivelRisco;
    }

    public void setNivelRisco(String nivelRisco) {
        this.nivelRisco = nivelRisco;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDate getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDate dataAlerta) {
        this.dataAlerta = dataAlerta;
    }


    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "AlertaAmbiental{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nivelRisco='" + nivelRisco + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataAlerta=" + dataAlerta +
                ", areaId=" + areaId +
                '}';
    }
}