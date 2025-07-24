package com.mitocode.controller;


import java.net.URI;
import java.util.List;


import com.mitocode.service.IPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mitocode.model.Paciente;


@RestController
@RequestMapping("/pacientes")
//@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {

	@Autowired
	private IPacienteService service;

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() throws Exception {
		List<Paciente> lista = service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) throws Exception {
//		Paciente obj = service.listarPorId(id);
//
//		if (obj == null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
//		}
//		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
//	}
//
//	@GetMapping("/hateoas/{id}")
//	public EntityModel<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {
//		Paciente obj = service.listarPorId(id);
//
//		if (obj.getIdPaciente() == null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
//		}
//
//		// localhost:8080/pacientes/{id}
//		EntityModel<Paciente> recurso = EntityModel.of(obj);
//
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
//
//		recurso.add(linkTo.withRel("paciente-recurso"));
//
//		return recurso;
//	}
//
//	/*
//	 * @PostMapping public ResponseEntity<Paciente> registrar(@Valid @RequestBody
//	 * Paciente p) { Paciente obj = service.registrar(p); return new
//	 * ResponseEntity<Paciente>(obj, HttpStatus.CREATED); }
//	 */
//
	@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente p) throws Exception {
		Paciente obj = service.registrar(p);

		// localhost:8080/pacientes/2
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(obj.getIdPaciente()).toUri();
//		return ResponseEntity.created(location).build();
	}
//
//	@PutMapping
//	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente p) throws Exception {
//		Paciente obj = service.modificar(p);
//		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
//		Paciente obj = service.listarPorId(id);
//
//		if (obj == null) {
//			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
//		}
//
//		service.eliminar(id);
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
//
//
//	@GetMapping("/pageable")
//	public ResponseEntity<Page<Paciente>> listarPageable(Pageable pageable) throws Exception{
//		Page<Paciente> pacientes = service.listarPageable(pageable);
//		return new ResponseEntity<Page<Paciente>>(pacientes, HttpStatus.OK);
//	}
}
