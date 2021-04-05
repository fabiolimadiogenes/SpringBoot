package com.LojaVirtual.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.Ecommerce.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {
	
	public List<Loja> findAllByNomeContainingIgnoreCase(String nome);

}
