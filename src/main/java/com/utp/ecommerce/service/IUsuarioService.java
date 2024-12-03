package com.utp.ecommerce.service;

import java.util.Optional;

import com.utp.ecommerce.model.Usuario;

public interface IUsuarioService {
	Optional<Usuario> findById(Integer id);
}
