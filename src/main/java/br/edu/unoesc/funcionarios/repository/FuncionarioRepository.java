package br.edu.unoesc.funcionarios.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.funcionarios.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	public List<Funcionario> findByNomeContainingIgnoreCase(String nome);
	
	public Page<Funcionario> findByNomeContainingIgnoreCase(String nome, Pageable pagina);
	
	@Query("Select f from Funcionario f where f.salario >= :salario")
	public List<Funcionario> porSalario(@Param("salario") BigDecimal salario);
	
	@Query("Select f from Funcionario f where upper(f.nome) like upper(concat('%', :filtro, '%')) order by nome")
	public List<Funcionario> findByFiltro(@Param("filtro") String filtro);
}