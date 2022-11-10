package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Avaliacao;
import br.com.senac.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository _context;
	
	public Avaliacao save(Avaliacao avaliacao) {
		return _context.save(avaliacao);
	}
	
	public List<Avaliacao> findAll(){
		return _context.findAll();
	}
}
