package br.com.wstriad.dto;

import java.util.Date;

public class RealatorioDTO {

    private Date dia;
    private Double total;

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public RealatorioDTO(Date dia, Double total) {
        this.dia = dia;
        this.total = total;
    }

    public RealatorioDTO() {

    }
}
