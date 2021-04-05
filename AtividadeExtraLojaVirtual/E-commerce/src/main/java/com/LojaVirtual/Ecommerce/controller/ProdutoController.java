package com.LojaVirtual.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.Ecommerce.model.Produto;
import com.LojaVirtual.Ecommerce.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{tituloProduto}")
	public ResponseEntity<List<Produto>> getByTituloProduto (@PathVariable String tituloProduto)
	{
		return ResponseEntity.ok(repository.findAllByTituloProdutoContainingIgnoreCase(tituloProduto));
	}
	
	@GetMapping("/{valor}")
	public ResponseEntity<List<Produto>> getByValor (@PathVariable Float valor)
	{
		return ResponseEntity.ok(repository.findAllByValor(valor));
	}
	
	@GetMapping("/valorMaior/{valor}")
    public ResponseEntity<List<Produto>> getAllByValorMaior(@PathVariable float valor) {
        return ResponseEntity.ok(repository.findAllByValorGreaterThanEqual(valor));
    }

    @GetMapping("/valorMenor/{valor}")
    public ResponseEntity<List<Produto>> getAllByValorMenor(@PathVariable float valor) {
        return ResponseEntity.ok(repository.findAllByValorLessThanEqual(valor));
    }
	
	@GetMapping("/valorMaior45{valor}")
	public ResponseEntity<List<Produto>> getByValorMaior45 (@PathVariable Float valor)
	{
		return ResponseEntity.ok(repository.findAllValorMaior45(valor));
	}
	
	@GetMapping("/nomeLoja{nome}")
	public ResponseEntity<List<Produto>> getByNomeLoja (@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllProdutoByNomeLoja(nome));
	}
	
	@PostMapping
	public ResponseEntity <Produto> post (@RequestBody Produto produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto)
	{
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id)
	{
		repository.deleteById(id);
	}
	
}
