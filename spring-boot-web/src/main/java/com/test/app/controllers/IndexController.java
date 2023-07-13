package com.test.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.models.Usuario;

//LA ANOTACION CONTROLER DEBE IR EN TODAS LAS CLASES 
//EN LAS QUE SE VA A UTILIZAR COMO CONTROLADOR
@Controller

//LA ANOTACION DE REQUEST MAPPING ES PARA HACER REFERENCIA A LA RUTA BASE EN DONDE SE VA 
//A LLAMAR EL CONTROLADOR
@RequestMapping("/app")
public class IndexController {
	
//LA RUTA GETMAPPING ES PARA DEFINIR EL METODO EN QUE SE VA UTILIZAR LA HORA DE INVOCAR
//EL METODO 
	
//TAMBIEN SE PUEDE USAR REQUESTMAPPING EN DONDE SE DEFINE LA RUTA Y A LA VEZ EL METODO U POSTMAPPING
	
	@GetMapping(value="/inicio")
	public String index(Model modelo) {
		modelo.addAttribute("titulo", "Holissss");
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ander");
		usuario.setApellido("Castro");
		usuario.setEmail("edwin.espino@gmail.com");
		model.addAttribute("titulo", "Bienvenido al Perfil de Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfil", 	"Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listarUsuario(Model model) {
		Usuario us1 = new Usuario();
		us1.setNombre("EDWIN RAFAEL");
		us1.setApellido(" ESPINO MENDOZA");
		us1.setEmail("edwin.espino@gmail.com");
		Usuario us2 = new Usuario();
		us2.setNombre("CARLOS");
		us2.setEmail("carlos.mendoza@gmail.com");
		us2.setApellido("MENDOZA");
		List<Usuario> listU = new ArrayList<>();
		listU.add(us1);
		listU.add(us2);
		model.addAttribute("usuarios", listU);
		return "listar";
		
	}
	
	//LA ANOTACION MODELO ATRIBUTE SE UTILIZA PARA CREAR UN METODO EN DONDE
	//SE VA A REUTILIZAR LOS DATOS PARA ENVIARLOS A TODAS LAS VISTAS
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		/*El metodo Arralist devuelve una lista de lo que se le ingrese por paramatros*/
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzman","andres@gomez.com"));
		return usuarios;
	}
			
	
	
	
	

}
