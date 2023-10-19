package com.senai.antonia.PrjGame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.antonia.PrjGame.entities.Jogo;
import com.senai.antonia.PrjGame.services.JogoService;

@RestController 
@RequestMapping("/jogos")
public class JogoController {
	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}
	
	@PostMapping
	public Jogo createGame(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo (@PathVariable Long id){
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
			}
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	@GetMapping 
	public List<Jogo> getAllJogos(){
		return jogoService.getAllJogos();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
}
