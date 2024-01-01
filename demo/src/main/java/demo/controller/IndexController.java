package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Usuario;

@RestController //arquitetura rest
@RequestMapping(value = "/usuario")
public class IndexController {

	//ja e um serviço restfull
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> init() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("Paulo");
		usuario.setLogin("PGO");
		usuario.setSenha("12345678");
		

		Usuario usuario2 = new Usuario();
		usuario2.setId(12L);
		usuario2.setNome("ana");
		usuario2.setLogin("aGO");
		usuario2.setSenha("12345678");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario2);
		usuarios.add(usuario);
 	
		return new ResponseEntity(usuarios, HttpStatus.OK);
	}
	
	
}
