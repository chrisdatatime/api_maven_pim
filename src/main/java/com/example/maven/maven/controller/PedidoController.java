package com.example.maven.maven.controller;

import com.example.maven.maven.model.Pedido;
import com.example.maven.maven.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Listar todos os pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    // Buscar um pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Criar um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    // Atualizar um pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = pedidoOptional.get();
        pedido.setValorTotal(pedidoDetails.getValorTotal());
        pedido.setStatus(pedidoDetails.getStatus());
        pedido.setDataRealizado(pedidoDetails.getDataRealizado());
        pedido.setDataEmTransito(pedidoDetails.getDataEmTransito());
        pedido.setDataEntregue(pedidoDetails.getDataEntregue());
        pedido.setDataCancelado(pedidoDetails.getDataCancelado());

        Pedido updatedPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    // Deletar um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent()) {
            pedidoRepository.delete(pedido.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}