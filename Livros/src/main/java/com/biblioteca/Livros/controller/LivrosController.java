package com.biblioteca.Livros.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.Livros.entities.Livro;
import com.biblioteca.Livros.service.LivrosService;






@RestController
@RequestMapping("/livros")
public class LivrosController {

	private final LivrosService livroService;
	
	@Autowired
	public LivrosController(LivrosService livroService) {
		this.livroService = livroService;
	}
	
	@PostMapping
	public Livro createProduct(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);
	}

	//Utilizando o ResponseEntity e RequestEntity
			@GetMapping
			public ResponseEntity<List<Livro>> getAllLivro(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Livro> livro = livroService.getAllLivro();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(livro);
			}
			@PutMapping("/{id}")
			public Livro updateJogo(@PathVariable Long id, @RequestBody Livro livro) {
			    return livroService.updateLivro(id, livro);
			}
		
			@GetMapping("/{id}")
			public ResponseEntity<Livro> getJogo (@PathVariable Long id) { 
				Livro livro = livroService.getLivroById(id);
			if (livro != null) {
			return ResponseEntity.ok (livro);
			} else {
			return ResponseEntity.notFound ().build();
			  }
			}
			
			@GetMapping ("/home")
			public String paginaInicial () {
			 return "index"; // Nome do seu arquivo HTML (sem a extensão)
			}
			
			@DeleteMapping("/{id}")
			public void deleteLivro(@PathVariable Long id) {
				livroService.deleteLivro(id);
			}
}
