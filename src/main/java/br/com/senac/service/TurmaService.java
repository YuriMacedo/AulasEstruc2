package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository repo;
	public List<Turma> selectAll(){
		return repo.findAll();
	}
	
	public Turma insert(Turma turma) {
		return repo.save(turma);
	}
	
	public Turma select(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void update(Turma turmaAlterada) {
		Turma turma = select(turmaAlterada.getId());
		turma.setNome(turmaAlterada.getNome());
		insert(turma);
	}
	
	public Turma buscaListaAlunosTurma(Integer id) {
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(id, "Turma não encontrada"));
	}
	
	public Turma findTurmaByIdTurma(Integer id) {
		Turma turma = repo.findTurmaByIdTurma(id);
		return turma;
	}
}
