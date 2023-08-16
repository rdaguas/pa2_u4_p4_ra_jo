package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.IPropietarioService;
import com.example.demo.repository.modelo.Propietario;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.propietarioService.buscarTodo();
		modelo.addAttribute("propietarios", lista);
		return "vistaListaPropietarios";
	}

}
