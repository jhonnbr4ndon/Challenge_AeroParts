package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.ProdutoDTO;
import br.com.fiap.models.Produto;

public class ProdutoMapper {

    public static Produto entity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        return produto;
    }

    public static ProdutoDTO entityDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        return produtoDTO;
    }

}
