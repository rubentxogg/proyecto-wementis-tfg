package com.rgg.wementis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.entities.UserEntity;
import com.rgg.wementis.services.interfaces.IUserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/users")
	public Iterable<UserEntity> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping(value = "/users")
	public void insertarUsuario(@RequestBody UserEntity user) {
		userService.insertarUsuario(user);
	}
	
	@PutMapping(value = "/users")
	public void actualizarUsuario(@RequestBody UserEntity user) {
		userService.actualizarUsuario(user);
	}
	
	@DeleteMapping(value = "/users/{username}")
	public void borrarUsuario(@RequestParam(value = "username", required = true) String username) {
		userService.borrarUsuario(username);
	}
}
