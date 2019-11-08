package br.com.wstriad.repository;

import br.com.wstriad.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRespository extends JpaRepository<Veiculo, Long> {

}
