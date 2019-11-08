package br.com.wstriad.repository;

import br.com.wstriad.domain.RegraPreco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegraPrecoRepository extends JpaRepository<RegraPreco, Long> {

}
