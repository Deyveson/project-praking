package br.com.wstriad.controller;

import br.com.wstriad.domain.Voucher;
import br.com.wstriad.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/parking")
public class CarController {

    @Autowired
    private AluguelService service;

    @RequestMapping(value = "/entrada", method = RequestMethod.POST)
    public Voucher createVoucher(@RequestParam(value = "placa", defaultValue = "", required = false) String palca,
                                 @RequestParam(value = "modelo", defaultValue = "", required = false) String modelo,
                                 @RequestParam(value = "cor", defaultValue = "", required = false) String cor) {
        return service.createVouche(palca, modelo, cor);
    }

    @RequestMapping(value = "/saida", method = RequestMethod.POST)
    public Voucher payVoucher(@RequestParam(value = "vouche", defaultValue = "", required = false) Long vouche) {
        return service.payVoucher(vouche);
    }

    @RequestMapping(value = "/faturamento", method = RequestMethod.GET)
    public String dailyBilling(@RequestParam(value = "Dia", defaultValue = "", required = false) String dia) {


        return service.faturamento(dia);
    }

}
