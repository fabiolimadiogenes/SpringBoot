package com.LojaVirtual.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.LojaVirtual.Ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByTituloProdutoContainingIgnoreCase (String TituloProduto);
	
	public List<Produto> findAllByValor (Float valor);
	
	public List<Produto> findAllByValorLessThanEqual(Float valor);
	
	public List<Produto> findAllByValorGreaterThanEqual(Float valor);
	
	 @Query(value = "select * from tb_produto where tb_pproduto.valor > 45", nativeQuery = true) 
	    public List<Produto> findAllValorMaior45(@Param("valorMaior45") Float valor);
	 
	 @Query(value = "select * from tb_produto inner join tb_loja on tb_loja.id = tb_produto.loja_id;", nativeQuery = true) 
	    public List<Produto> findAllProdutoByNomeLoja(@Param("nomeLoja") String nome);

}
