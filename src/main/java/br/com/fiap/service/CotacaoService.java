package br.com.fiap.service;

import br.com.fiap.repository.CotacaoRepository;
import br.com.fiap.controller.dto.CotacaoDTO;
import br.com.fiap.models.Cotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public Cotacao criarCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    public List<Cotacao> listarCotacoes() {
        return cotacaoRepository.findAll();
    }

    public Cotacao encontrarCotacaoPorID(Long id) {
        return cotacaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cotação não encontrado com o ID: " + id));
    }

    public void atualizarCotacao(CotacaoDTO cotacaoDTO) {
        Optional<Cotacao> optionalCotacao = cotacaoRepository.findById(cotacaoDTO.getId());
        if (optionalCotacao.isPresent()) {
            Cotacao cotacao = optionalCotacao.get();
            cotacao.setData(cotacaoDTO.getData());
            cotacao.setPreco(cotacaoDTO.getPreco());
            cotacaoRepository.save(cotacao);
        } else {
            throw new RuntimeException("Cotação não encontrado com o ID: " + cotacaoDTO.getId());
        }
    }

    public void removerCotacao(Long id) {
        cotacaoRepository.deleteById(id);
    }
}
