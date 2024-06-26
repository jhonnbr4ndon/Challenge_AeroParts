package br.com.fiap.service;

import br.com.fiap.controller.dto.UsuarioDTO;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario encontrarUsuarioPorID(Long id) {
        return usuarioRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public void atualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDTO.getId());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setSenha(usuarioDTO.getSenha());
            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + usuarioDTO.getId());
        }
    }

    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
