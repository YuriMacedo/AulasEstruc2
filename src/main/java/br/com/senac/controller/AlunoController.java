package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private TurmaService turmaService;
	@GetMapping("/listarAlunos")
	public ModelAndView listaTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
		mv.addObject("alunos", alunoService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarAluno")
	public ModelAndView cadastrArluno() {
		ModelAndView mv = new ModelAndView("aluno/cadastrarAluno");
		mv.addObject("aluno",new Aluno());
		mv.addObject("listaTurma", turmaService.selectAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.insert(aluno);
		return listaTodosAlunos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirAluno(@PathVariable("id") Integer id) {
		alunoService.delete(id);
		return listaTodosAlunos();
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView atualizarAluno(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno", alunoService.select(id)); 
		mv.addObject("listaTurma", turmaService.selectAll());
		return mv;
	}
		
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterar(Aluno alunoAlterado) {
		alunoService.update(alunoAlterado);
		return listaTodosAlunos();
	}
}
