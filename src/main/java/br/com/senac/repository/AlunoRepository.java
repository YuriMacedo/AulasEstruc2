package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByNome(String nome);
	
	@Query(value = "Select distinct a from aluno a join fetch a.enderecos b")
	List<Aluno> buscarAlunoComEndereco();
	
	@Query(value = "Select distinct a from aluno a join fetch a.enderecos b where a.nome = ?1")
	List<Aluno> buscaAlunoPeloNome(String nome);
}
