package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.IPropietarioService;
import com.example.demo.repository.modelo.Propietario;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
	
	@Autowired
	//http://localhost:8080/concensionario/propietarios/buscar
	private IPropietarioService propietarioService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.propietarioService.buscarTodo();
		modelo.addAttribute("propietarios", lista);
		return "vistaListaPropietarios";
	}
	//http://localhost:8080/concensionario/propietarios/seleccionarPorID/27
	@GetMapping("/seleccionarPorID/{idPropietario}")
	public String seleccionarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		Propietario prop =  this.propietarioService.seleccionarPorId(id);
		model.addAttribute("propietarios", prop);
		return "vistaPropietario";
	}
	
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(Integer id, Propietario propietario) {
		this.propietarioService.modificar(propietario);
		return "redirect:/propietarios/buscar";
	}
	
	

}
