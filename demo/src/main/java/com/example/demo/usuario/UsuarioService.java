package com.example.demo.usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.pedido.PedidoRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository ) {
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
    }

    // Criar usuário
    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO dto) {
        Usuario usuario = dto.toEntity(); // DTO -> entidade
        Usuario salvo = usuarioRepository.save(usuario);
        return UsuarioDTO.fromEntity(salvo); // entidade -> DTO
    }

    // Listar todos
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Buscar por id
    @Transactional(readOnly = true)
    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElse(null); // depois podemos trocar por exceção customizada

        return UsuarioDTO.fromEntity(usuario);
    }
}