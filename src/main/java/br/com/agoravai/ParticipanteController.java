package br.com.agoravai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.agoravai.model.Participante;
import br.com.agoravai.service.ParticipanteService;
import br.com.thaisdalencar.sendEmail.sendEmail.EmailService;

@Controller
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;	
	
	@RequestMapping("/")
	public String index () {
		return "index";
	}
	
	@RequestMapping("listaParticipantes")
	public String listaParticipantes (Model model) {		
		Iterable<Participante> participantes = service.obterTodos();
		model.addAttribute("participantes", participantes);
		
		return "participantes";
	}
	
	@RequestMapping(value="salvar", method= RequestMethod.POST)
	public String salvar (@RequestParam("nome") String nome, 
			@RequestParam("numero") int numero, @RequestParam("email") String email, Model model) {
		
		String myEmail = "thaisdalencar@gmail.com";
		String myPsw = "88663899";
		String subject = "Você foi convidado para um sorteio";
		String msg = "Olá," + nome + ". Você está participando de um sorteio";
		
		Participante novoParticipante = new Participante(nome, numero);
		service.salvar(novoParticipante);
		new EmailService().send(myEmail, myPsw, nome, email, subject, msg);
		
		Iterable<Participante> participantes = service.obterTodos();		
		model.addAttribute("participantes", participantes);
		return "participantes";
	}
	
}
