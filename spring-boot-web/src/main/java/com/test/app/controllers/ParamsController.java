package com.test.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/mix-params")
	public String index(@RequestParam String saludo, @RequestParam Integer numero, Model modelo) {
		modelo.addAttribute("texto", "El  saludo es: "+saludo+" y el numero es: "+ numero+ " ");
		return "params/ver";
	}
	
	

	@GetMapping("/string")
	//REQUESTPARAM ES UNA ANOTACION PARA OBTENER EL VALOR DE LOS PARAMETROS ENVIADOS
	//EN EL REQUEST
	public String param(@RequestParam( required=false, defaultValue="Default") String texto,  Model model) {
		model.addAttribute("texto", texto);
		return "params/ver";
	}
}
