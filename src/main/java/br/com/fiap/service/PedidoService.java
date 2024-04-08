package br.com.fiap.service;

import br.com.fiap.controller.dto.PedidoDTO;
import br.com.fiap.models.Pedido;
import br.com.fiap.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido encontrarPedidoPorID(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    public void atualizarPedidos(PedidoDTO pedidoDTO) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoDTO.getId());
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.setData(pedidoDTO.getData());
            pedido.setStatus(pedidoDTO.getStatus());
            pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Pedido não encontrado com o ID: " + pedidoDTO.getId());
        }
    }

    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
