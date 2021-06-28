package com.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.Models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);
}
