package com.example.demo.pedido;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.usuario.Usuario;
import com.example.demo.usuario.UsuarioRepository;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public PedidoDTO criarPedido(PedidoDTO dto) {
        Long usuarioId = dto.getUsuarioId();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if(usuario == null){
            throw new RuntimeException("Usuario com o id "+usuarioId+" não encontrado");
        }
        
        Pedido pedido = dto.toEntitySemUsuario();
        pedido.setUsuario(usuario);
        pedido.setDataCriacao(Instant.now());
        Pedido salvo = pedidoRepository.save(pedido);
        return PedidoDTO.fromEntity(salvo);
    }

    @Transactional(readOnly = true)
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(PedidoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PedidoDTO buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElse(null); // depois podemos trocar por exceção customizada

        return PedidoDTO.fromEntity(pedido);
    }

    @Transactional(readOnly = true)
    public List<PedidoDTO> listarPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(PedidoDTO::fromEntity)
                .collect(Collectors.toList());
    }
}