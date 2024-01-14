package demo.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Usuario;
import demo.repository.UsuarioRepository;

@RestController //arquitetura rest
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/pdf")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "id")Long id
		                                    ,@PathVariable (value = "venda")Long venda){
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
 	    //retorno seria um relatorio
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	
	//ja e um serviço restfull
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id")Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
 	
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuarios (){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/" , produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		for (int pos = 0; pos < usuario.getTelefones().size(); pos ++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
			
		}
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/{iduser}/venda/{idvenda}" , produces = "application/json")
	public ResponseEntity cadastrar(@PathVariable Long iduser, @PathVariable Long idvenda){
		
	//	Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity("concluido com sucesso" + iduser + +idvenda, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/" , produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		//aqui vai outras rotinas antes de atualizar
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{iduser}" , produces = "application/text")
	public String deletarusuario(@PathVariable Long iduser) {
		
		usuarioRepository.deleteById(iduser);
		
		return "Deletado";
	}
	
}
