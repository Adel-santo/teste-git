package com.produtos.resources;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.Models.Produto;
import com.produtos.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST produtos")
@CrossOrigin(origins="*")
public class ProdutoResources {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
		
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="lista de produto")
	public Produto listaProdutoUnico(@PathVariable(value="id")long id){
		return produtoRepository.findById(id);
	}
	

	@PostMapping("/produto")
	@ApiOperation(value="salva produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="deleta de produtos")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="altera de produtos")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
