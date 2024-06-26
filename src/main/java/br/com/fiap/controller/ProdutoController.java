package br.com.fiap.controller;

import br.com.fiap.controller.dto.ProdutoDTO;
import br.com.fiap.models.Produto;
import br.com.fiap.service.ProdutoService;
import br.com.fiap.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/novo")
    public String criarProduto(@ModelAttribute ProdutoDTO produtoDTO) {
        produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
        return "redirect:/produto";
    }

    @GetMapping("/novo")
    public String formularioNovoProduto(Model model) {
        model.addAttribute("produtoDTO", new ProdutoDTO());
        return "produtoForm";
    }

    @GetMapping
    public String listarProdutos(Model model) {
        List<ProdutoDTO> produtoDTO = produtoService.listarProdutos().stream().map(ProdutoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("produtoDTO", produtoDTO);
        return "produto";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoService.encontrarProdutoPorID(id);
        model.addAttribute("produtoDTO", ProdutoMapper.entityDTO(produto));
        return "produtoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute ProdutoDTO produtoDTO) {
        produtoDTO.setId(id);
        produtoService.atualizarProduto(produtoDTO);
        return "redirect:/produto";
    }

    @GetMapping("/delete/{id}")
    public String removerProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return "redirect:/produto";
    }
}
