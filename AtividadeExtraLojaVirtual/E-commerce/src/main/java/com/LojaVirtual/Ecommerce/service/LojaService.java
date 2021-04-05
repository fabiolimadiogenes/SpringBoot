package com.LojaVirtual.Ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LojaVirtual.Ecommerce.model.Loja;
import com.LojaVirtual.Ecommerce.model.Produto;
import com.LojaVirtual.Ecommerce.repository.LojaRepository;
import com.LojaVirtual.Ecommerce.repository.ProdutoRepository;

@Service
public class LojaService {
	
	@Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public Loja cadastroProdutoLoja(long lojaId, long produtoId) {

        Optional<Produto> produtoExistente = produtoRepository.findById(produtoId);
        Optional<Loja> lojaExistente = lojaRepository.findById(lojaId);

        if (produtoExistente.isPresent() && lojaExistente.isPresent()) {

            lojaExistente.get().getProduto().add(produtoExistente.get());

            lojaRepository.save(lojaExistente.get());

            return lojaRepository.save(lojaExistente.get());
        }
        return null;

    }
}
