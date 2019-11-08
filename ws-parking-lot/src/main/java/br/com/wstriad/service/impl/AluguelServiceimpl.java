package br.com.wstriad.service.impl;

import br.com.wstriad.domain.RegraPreco;
import br.com.wstriad.domain.Voucher;
import br.com.wstriad.dto.RealatorioDTO;
import br.com.wstriad.repository.RegraPrecoRepository;
import br.com.wstriad.repository.VeiculoRespository;
import br.com.wstriad.repository.VoucherRepository;
import br.com.wstriad.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "AluguelService")
public class AluguelServiceimpl implements AluguelService {

    @Autowired
    RegraPrecoRepository precoRepository;

    @Autowired
    VeiculoRespository veiculoRespository;

    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public Voucher createVouche(String placa, String modelo, String cor) {

        Voucher voucher = new Voucher();
        Date dataAtual = new Date();

        voucher.setEntrada(dataAtual);

        voucher.getVeiculo().setPlaca(placa);
        voucher.getVeiculo().setModelo(modelo);
        voucher.getVeiculo().setCor(cor);
        voucher.getVeiculo().setVoucher(voucher);

        return voucherRepository.save(voucher);
    }

    @Override
    public Voucher payVoucher(Long vouche) {

        Voucher voucher;
        List<RegraPreco> regraPrecos;
        Date dataAtual = new Date();
        GregorianCalendar gc = new GregorianCalendar();

        voucher = voucherRepository.findById(vouche).orElseThrow(() ->
                new EntityNotFoundException("Voucher não existe, ou codigo foi digitado errado"));

        regraPrecos = precoRepository.findAll();

        regraPrecos.forEach(regraPreco -> {
            if (gc.get(Calendar.DAY_OF_WEEK) >= regraPreco.getDia_inicio() &&
                    gc.get(Calendar.DAY_OF_WEEK) <= regraPreco.getDia_final()) {

                Boolean horario = checkHora(regraPreco.getHora_inicio(), regraPreco.getHora_final(), regraPreco);

                if (horario == true) {
                    voucher.setSaida(dataAtual);
                    voucher.setPreco(regraPreco.getValor());
                    voucherRepository.save(voucher);
                }
            }
        });

        return voucher;
    }

    ;

    public Boolean checkHora(Date inicio, Date fim, RegraPreco regraPreco) {

        Date date = new Date();
        SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {

            Date dataAtual = sdfo.parse(sdfo.format(date));
            Date dataInicial = sdfo.parse(inicio.toString());
            Date dataFinal = sdfo.parse(fim.toString());

            if (dataAtual.compareTo(dataInicial) > 0 && dataAtual.compareTo(dataFinal) < 0) {
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return false;
    }

    ;


    public String faturamento(String dia) {

//        Date date = new Date(2019, 11, 9, 18, 00);
//
//		String dateinicio = "2019-11-08";
//        String datefim = "2019-11-08 18:00";
//
//        System.out.println(dia);
//        List<RealatorioDTO> listvoucher = voucherRepository.findFaturamento(1);
//
//        listvoucher.forEach(res -> {
//            System.out.println("Voucher ------> " + res.getTotal());
//        });

        return "Sucesso";
    }

    ;


}
