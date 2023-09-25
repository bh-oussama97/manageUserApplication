package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Utilisateur;
import com.example.service.UtilisateurService;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	UtilisateurService userService;
	

	@GetMapping("/all")
	public List<Utilisateur> getAllUsers(){
		return userService.getAll();
	}
	
	
	@PostMapping("/add")
	public String addUser(@RequestBody Utilisateur user)
	{
		return userService.addUser(user);
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateUser(@PathVariable("id") int userId,@RequestBody Utilisateur newUser) throws Exception {
		return userService.updateUser(userId,newUser);

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		return userService.deleteUser(id);
	}
		

}
