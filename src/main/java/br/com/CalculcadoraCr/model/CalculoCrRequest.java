package br.com.CalculcadoraCr.model;

import java.util.List;

public class CalculoCrRequest {
    private List<Nota> notas;
    private List<CargaHoraria> cargasHorarias;

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<CargaHoraria> getCargaHoraria() {
        return cargasHorarias;
    }

    public void setCargasHorarias(List<CargaHoraria> cargasHorarias) {
        this.cargasHorarias = cargasHorarias;
    }
}
