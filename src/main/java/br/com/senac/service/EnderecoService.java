package br.com.senac.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Endereco;
import br.com.senac.repository.EnderecoRepository;

@Service
public class EnderecoService {
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> getAllEndereco(){
		return enderecoRepository.findAll();
	}
	
	public Endereco createEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco getEnderecoById(Integer id) throws ObjectNotFoundException{
//		Optional<Endereco> Endereco = enderecoRepository.findAllById(id);
//		
//		return Endereco.orElseThrow( ()-> new ObjectNotFoundException(1L, "Endereço não encontrado"));
		return enderecoRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	public void alterar(Endereco enderecoAlterado) {
		Endereco endereco = getEnderecoById(enderecoAlterado.getId());		
		endereco.setBairro(enderecoAlterado.getBairro());
		endereco.setCep(enderecoAlterado.getCep());
		endereco.setComplemento(enderecoAlterado.getComplemento());
		endereco.setRua(enderecoAlterado.getRua());
		endereco.setNumero(enderecoAlterado.getNumero());
		createEndereco(endereco);
	}
	
	public List<Endereco> buscar(Aluno aluno){
		return enderecoRepository.findByAluno(aluno);
		
	}
}
