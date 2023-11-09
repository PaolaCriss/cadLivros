package com.biblioteca.Livros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.Livros.entities.Livro;
import com.biblioteca.Livros.repositories.LivroRepository;

@Service
public class LivrosService {

	private final LivroRepository livrosRepository;
	 
    @Autowired
    public LivrosService(LivroRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public Livro saveLivro(Livro livro) {
        return livrosRepository.save(livro);
    }

  //preparando a busca getsl
  	public List<Livro> getAllLivro(){
  		return livrosRepository.findAll();
  	}
  	
  	public Livro getLivroById (Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
  	
  //deletando
  	public void deleteLivro(Long id) {
  		livrosRepository.deleteById(id);
  	}
  	
 // fazendo o update do jogo com o optional
 		public Livro updateLivro(Long id, Livro novoLivro) {
 	        Optional<Livro> livroOptional = livrosRepository.findById(id);
 	        if (livroOptional.isPresent()) {
 	        	Livro livroExistente = livroOptional.get();
 	           	livroExistente.setDescription(novoLivro.getDescription());
 	        	livroExistente.setIsbn(novoLivro.getIsbn());          
 	            return livrosRepository.save(livroExistente); 
 	        } else {
 	            return null; 
 	        }
 	    }
}
