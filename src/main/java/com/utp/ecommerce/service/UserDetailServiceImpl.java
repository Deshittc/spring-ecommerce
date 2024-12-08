package com.utp.ecommerce.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utp.ecommerce.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    HttpSession session;
    
    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Este es el username");
        Optional<Usuario> optionalUser = usuarioService.findByEmail(username);
        if (optionalUser.isPresent()) {
            log.info("Esto es el id del usuario: {}", optionalUser.get().getId());
            session.setAttribute("idusuario", optionalUser.get().getId());
            Usuario usuario = optionalUser.get();
            
            // Aquí asumimos que la contraseña ya está codificada en la base de datos
            return User.builder()
                       .username(usuario.getNombre())
                       .password(usuario.getPassword())  // La contraseña ya debería estar codificada
                       .roles(usuario.getTipo())
                       .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
