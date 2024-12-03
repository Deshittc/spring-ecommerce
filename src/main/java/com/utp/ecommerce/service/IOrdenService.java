package com.utp.ecommerce.service;

import java.util.List;

import com.utp.ecommerce.model.Orden;

public interface IOrdenService {
	List<Orden> findAll();
	Orden save (Orden orden);
}
