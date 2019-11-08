package br.com.wstriad.repository;

import br.com.wstriad.domain.Voucher;
import br.com.wstriad.dto.RealatorioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

//    static String selectForWhere = "SELECT new br.com.wstriad.dto.RealatorioDTO(V.SAIDA, SUM(V.PRECO))" +
//            "FROM VOUCHER V WHERE = :id";
//
//    @Query(selectForWhere)
//    List<RealatorioDTO> findFaturamento(int id);

}
