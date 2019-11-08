package br.com.wstriad.service;

import java.util.Date;
import java.util.List;

import br.com.wstriad.domain.Voucher;

public interface AluguelService {

    Voucher createVouche (String palca, String modelo, String cor);

    Voucher payVoucher(Long vouche);

    String faturamento (String dia);

}
