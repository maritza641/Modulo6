package cl.aiep.java.tesoreria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.tesoreria.modelo.Proveedor;
import cl.aiep.java.tesoreria.repositorio.ProveedorRepository;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@GetMapping("/nuevo")
	public String nuevo(Proveedor proveedor) {
		return "proveedor/form";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(name = "id") Proveedor proveedor, Model modelo) {
		modelo.addAttribute("proveedor", proveedor);
		return "proveedor/form";
	}
	
	@PostMapping("/procesar")
	public String procesar(@Valid Proveedor proveedor, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) return "proveedor/form";
		
		proveedorRepository.saveAndFlush(proveedor);
		return "redirect:/proveedor/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		proveedorRepository.deleteById(id);
		return "redirect:/proveedor/listado";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Proveedor> proveedores = proveedorRepository.findAll();
		modelo.addAttribute("proveedores", proveedores);
		return "proveedor/listado";
	}
}
