package br.com.wstriad.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VOUCHER")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "voucher")
    private Veiculo veiculo = new Veiculo();

    @Column(name = "ENTRADA")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date entrada;

    @Column(name = "SAIDA")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date saida;

    @Column(name = "PRECO")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double preco;

    public Voucher(Veiculo veiculo, Date entrada, Date saida, Double preco) {
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.preco = preco;
    }

    public Voucher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
