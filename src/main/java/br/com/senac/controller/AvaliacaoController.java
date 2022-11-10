package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Avaliacao;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("/adiciona")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("avaliacoes/inserir-nota");
		mv.addObject("alunos",alunoService.selectAll());
		mv.addObject("cursos", cursoService.selectAll());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@PostMapping
	public ModelAndView save(@ModelAttribute("avaliacao") Avaliacao avaliacao) {
		avaliacao.getAlunoCurso().setAluno(alunoService.select(avaliacao.getAlunoCurso().getAluno().getId()));
		avaliacao.getAlunoCurso().setCurso(cursoService.select(avaliacao.getAlunoCurso().getCurso().getId()));
		ModelAndView mv = new ModelAndView("avaliacoes/listar-nota");
		mv.addObject("avaliacaoes", avaliacaoService.findAll());
		return mv;
	}

}
