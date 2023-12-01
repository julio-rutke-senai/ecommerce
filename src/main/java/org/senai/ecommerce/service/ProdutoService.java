package org.senai.ecommerce.service;

import org.senai.ecommerce.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService{

    List<Produto> produtos;

    public ProdutoService(){
        produtos = new ArrayList();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProdutoPorCodigo(Long codigo) {
        return produtos.stream().filter(produto -> produto.getCodigo() == codigo).findFirst().get();
    }

    public Produto criarProduto(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public Produto atualizarProduto(Long codigo, Produto produtoAlteracao) {
        produtos.forEach(produto -> {
            if (produto.getCodigo() == codigo) {
                produto.setNome(produtoAlteracao.getNome());
                produto.setDescricao(produtoAlteracao.getDescricao());
                produto.setPreco(produtoAlteracao.getPreco());
                produto.setEstoque(produtoAlteracao.getEstoque());
            }
        });
        return produtoAlteracao;
    }

    public void excluirProduto(Long codigo) {
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }
}
