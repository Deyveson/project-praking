package br.com.wstriad.config;

import br.com.wstriad.domain.RegraPreco;
import br.com.wstriad.repository.RegraPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class RunFake implements CommandLineRunner {

    @Autowired
    RegraPrecoRepository precoRepository;

    @Override
    public void run(String... args) throws Exception {

        Date dataAtual = new Date();

        Date entradaRegra1 = new Date(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDate(), 8, 00);
        Date saidaRegra1 = new Date(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDate(), 12, 00);

        Date entradaRegra2 = new Date(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDate(), 12, 001);
        Date saidaRegra2 = new Date(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDate(), 18, 00);
        
        List<RegraPreco> list  = Arrays.asList(
                new RegraPreco("Segunda - Sexta", entradaRegra1, saidaRegra1, 2, 6, 2.00),
                new RegraPreco("Segunda - Sexta", entradaRegra2, saidaRegra2, 2, 6, 3.00),
                new RegraPreco("Sábado e domingo", entradaRegra1, saidaRegra2, 7, 1, 2.50));

        precoRepository.saveAll(list);

    }
}
