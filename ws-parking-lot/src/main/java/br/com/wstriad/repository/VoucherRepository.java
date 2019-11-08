package br.com.wstriad.repository;

import br.com.wstriad.domain.Voucher;
import br.com.wstriad.dto.RealatorioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

//    static String selectForWhere = "SELECT new br.com.wstriad.dto.RealatorioDTO(V.saida, SUM(V.preco))" +
//            "FROM Voucher V WHERE V.entrada < ?1";
//    @Query( select + " GROUP BY V.saida")

   @Query(value = "SELECT a.dia, sum(a.preco) total from (SELECT substr(entrada, 0,10) dia, preco FROM VOUCHER GROUP BY ENTRADA ) a GROUP BY dia", nativeQuery = true)
   String findFaturamento();

}
