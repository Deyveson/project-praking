package br.com.wstriad.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "REGRAPRECO")
public class RegraPreco {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DIAS", columnDefinition = "VARCHAR(20)")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dias;

	@Column(name = "HORA_INICIO")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date hora_inicio;

	@Column(name = "HORA_FINAL")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date hora_final;

	@Column(name = "DIA_INICIO")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int dia_inicio;

	@Column(name = "DIA_FIM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int dia_final;

	@Column(name = "VALOR")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double valor;

	public RegraPreco(String dias, Date hora_inicio, Date hora_final, int dia_inicio, int dia_final, Double valor) {
		this.dias = dias;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.dia_inicio = dia_inicio;
		this.dia_final = dia_final;
		this.valor = valor;
	}

	public RegraPreco() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_final() {
		return hora_final;
	}

	public void setHora_final(Date hora_final) {
		this.hora_final = hora_final;
	}

	public int getDia_inicio() {
		return dia_inicio;
	}

	public void setDia_inicio(int dia_inicio) {
		this.dia_inicio = dia_inicio;
	}

	public int getDia_final() {
		return dia_final;
	}

	public void setDia_final(int dia_final) {
		this.dia_final = dia_final;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
