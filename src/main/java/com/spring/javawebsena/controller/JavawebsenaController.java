package com.spring.javawebsena.controller;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.javawebsena.model.Simulador;
import com.spring.javawebsena.model.Usuario;
import com.spring.javawebsena.repository.UsuarioRepository;
import com.spring.javawebsena.service.JavawebsenaService;

@Controller
public class JavawebsenaController {

	Locale localeBR = new Locale("pt","BR");
	NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);
	
	private Usuario usuario;
	
	@Autowired
	JavawebsenaService javawebsenaService;

	
	@RequestMapping(value = "/simulador", method = RequestMethod.GET)
	public ModelAndView getSimulador () {
		ModelAndView mv = new ModelAndView("simulador");
		List<Simulador> simulador = javawebsenaService.findAll();
		mv.addObject("simulador", simulador);
		return mv;
	}
	
	
	@RequestMapping(value = "/simulador/{id}", method = RequestMethod.GET)
	public ModelAndView getSimuladorDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("simuladorDetails");
		Simulador simulador = javawebsenaService.findById(id);
		mv.addObject("simulador", simulador);
		return mv;
	}	
		
	@RequestMapping(value = "/cadastrarSimulacao", method = RequestMethod.GET)
	public String getformSimulador () {
		return "formSimulador";
	}
	

	@RequestMapping(value = "/cadastrarSimulacao", method = RequestMethod.POST)
	public String saveSimulador(@Valid Simulador simulador, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/cadastrarSimulacao";
		}
		simulador.setQuantidadeReqs(simulador.getAcessosDia() / simulador.getPeriodo());
		simulador.setVazaoRps(Math.round(simulador.getQuantidadeReqs() / 3600));	// 1h de teste em segundos.
		simulador.setQuantidadeVus(Math.round(simulador.getQuantidadeReqs() / (3600 / simulador.getSla())));
		simulador.setDate(LocalDate.now());
		javawebsenaService.save(simulador);
		return "redirect:/simulador";
	}
	
	@RequestMapping("/deletar")
	public String deletarPlano(long id) {
		Simulador simulador = javawebsenaService.findById(id);
		javawebsenaService.delete(simulador);
		return "redirect:/simulador";
	}
}