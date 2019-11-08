package br.com.wstriad.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@OneToOne
	@JsonIgnore
	private Voucher voucher;

	@Column(name = "PLACA", columnDefinition = "VARCHAR(8)")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String placa;

	@Column(name = "MODELO", columnDefinition = "VARCHAR(20)")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String modelo;

	@Column(name = "COR", columnDefinition = "VARCHAR(10)")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String cor;

	public Veiculo(String placa, String modelo, String cor) {
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}

	public Veiculo() {

	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

}
