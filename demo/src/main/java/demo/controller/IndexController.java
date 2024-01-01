package demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //arquitetura rest
@RequestMapping(value = "/usuario")
public class IndexController {

	//ja e um serviço restfull
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity init() {
		return new ResponseEntity ("Ola REST SPRING" , HttpStatus.OK);
	}
	
	
}
