package com.rgg.wementis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/users")
	public Iterable<UserEntity> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping(value = "/users", params = {"username"})
	public UserEntity getUser(@RequestParam String username) {
		return userService.getUserByUsername(username);
	}
	
	@PostMapping(value = "/users")
	public void insertarUsuario(@RequestBody UserEntity user) {
		userService.insertarUsuario(user);
	}
	
	@PutMapping(value = "/users")
	public void actualizarUsuario(@RequestBody UserEntity user) {
		userService.actualizarUsuario(user);
	}
	
	@DeleteMapping(value = "/delete", params = {"username"})
	public void borrarUsuario(@RequestParam String username) {
		userService.borrarUsuario(username);
	}
	
	@GetMapping(value = "/username")
	public String currUsername(Authentication authentication) {
		return authentication.getName();
	}
	
	@GetMapping(value = "/isauthenticated")
	public boolean isAuthenticated(Authentication authentication) {
		return authentication.isAuthenticated();
	}
}
