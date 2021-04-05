package com.LojaVirtual.Ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_loja")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long lojaId;
	
	@NotNull
	@Size(min = 3, max = 45)
	private String nomeLoja;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String descricao;
	
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loja")
	private Produto produto;
	
	@ManyToOne
	@JsonIgnoreProperties("loja")
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "inscricao", joinColumns = @JoinColumn(name = "loja_id"), 
			inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	@JsonIgnoreProperties({"nome", "usuario", "senha", "produto", "loja", "inscricoes"})
	private List<Usuario> usuarios = new ArrayList<>();

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public long getLojaId() {
		return lojaId;
	}

	public void setLojaId(long lojaId) {
		this.lojaId = lojaId;
	}

	
	

	
		
}
