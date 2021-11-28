package com.example.edelec.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "usuarios", nullable = false)
    private String userName;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "nombres", nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 6, max = 30, message = "Nombre no valido")
    @Column(name = "apellidos", nullable = false)
    private String apellido;

    @NotNull
    @Email
    @Column(name = "correos", nullable = false)
    private String correo;

    @NotNull
    @Size(min = 8,max = 16, message = "Contraseña no valida")
    @Column(name = "contraseñas", nullable = false)
    private String contrasena;


    @OneToMany(mappedBy = "user", cascade ={CascadeType.ALL})
    private List<Comentario> coment;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Test> tests;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
