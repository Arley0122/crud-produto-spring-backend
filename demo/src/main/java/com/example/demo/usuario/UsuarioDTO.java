package com.example.demo.usuario;

import com.example.demo.shared.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {

    private Long id; 

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 150, message = "Email deve ter no máximo 150 caracteres")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 100, message = "Senha deve ter entre 6 e 100 caracteres")
    private String senha;

    @NotBlank(message = "Role é obrigatória")
    private String role; // "USER" ou "ADMIN" (será convertido para enum no service)


    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nome, String email, String senha, String role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setId(this.id);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setRole(Role.valueOf(this.role));
        return usuario;
    }

    public static UsuarioDTO fromEntity(Usuario usuario){
        if(usuario == null){return null;}
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(null);
        dto.setRole(usuario.getRole().name());
        return dto;
    }
}