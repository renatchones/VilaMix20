package br.com.qintess.vilamix20.web.controller;

import java.beans.PropertyEditor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.vilamix20.dao.EventoDao;
import br.com.qintess.vilamix20.model.Evento;

import br.com.qintess.vilamix20.service.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Evento evento) {
		return "/evento/cadastro";
		
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/evento/lista";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Evento evento) {
		service.salvar(evento);
		return "redirect:/eventos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id , ModelMap model) {
		model.addAttribute("evento", service.buscarPorId(id));
		return "/evento/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(Evento evento) {
		service.editar(evento);
		return "redirect:/evento/cadastro";
	}
	

}
