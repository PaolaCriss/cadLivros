package com.biblioteca.Livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.Livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
