package com.br.teste.curso_springboot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.teste.curso_springboot.model.Usuario;
import com.br.teste.curso_springboot.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    @RequestMapping(value = "/usuario/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvarUsuario(@PathVariable String nome) {
    	try {
    		
	        Usuario usuario = new Usuario();
	        usuario.setNome(nome);
	        usuario.setIdade(37);
	        usuario.setId((long) 111111);
	        System.out.println(usuario.getNome());
	        usuarioRepository.save(usuario);
	    	return "Hello " + nome + "!";
    	}catch(Exception ex) {
    		System.out.println("Erro: "+ ex.getMessage());
    	}
    	return null;
    }*/

    @GetMapping(value = "/usuarios")
    public ResponseEntity<List<Usuario>> listaUsuarios(){
    	List<Usuario> usuarios = usuarioRepository.findAll();
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    @PostMapping(value = "/usuario/salvar")
    @ResponseBody
    public ResponseEntity<List<Usuario>> salvar(@RequestBody Usuario usuario){
    	Usuario user = usuarioRepository.save(usuario);
    	return listaUsuarios();
    }
    
    /*@DeleteMapping(value = "excluir")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long id){
    	usuarioRepository.deleteById(id);
    	return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
    }*/
    
    @RequestMapping(value = "/usuario/excluir/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Usuario>> excluir(@PathVariable Long id) {
    	usuarioRepository.deleteById(id);
    	return listaUsuarios();
    	
    }
    
    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> busca(@PathVariable Long id) {
    	Usuario usuario = usuarioRepository.findById(id).get();
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "/usuario/listar/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Usuario>> buscaPorNome(@PathVariable String nome) {
    	System.out.println("nome da pesquisa "+nome);
    	List<Usuario> usuario = usuarioRepository.buscaPorNome(nome.trim().toUpperCase());
    	return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "/usuario/editar/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> alterar(@RequestBody Usuario usuario) {
    	Usuario us = usuarioRepository.saveAndFlush(usuario);
    	return new ResponseEntity<Usuario>(us, HttpStatus.OK);
    }
    
}
