package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Utilisateur;
import com.example.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository userRepository;
	
	
	public List<Utilisateur> getAll()
	{
		return (List<Utilisateur>) userRepository.findAll();
	}
	
	public String addUser(Utilisateur user)
	{
		String response;
		if (userRepository.save(user) != null)
		{
			response = "user successfully added";
		}
		else {
			response = "something wen wrong ,not added , please try again";
		}
		return response;
	}
	
	
	public String updateUser(int userId,Utilisateur newUser)
	{
		String res;
		Utilisateur userManagedEntity = userRepository.findById(userId).get();
		if( userManagedEntity != null)
		{
			userManagedEntity.setFirstname(newUser.getFirstname());
			userManagedEntity.setLastname(newUser.getLastname());
			userManagedEntity.setEmail(newUser.getEmail());
			userManagedEntity.setPass(newUser.getPass());
			
			userRepository.save(userManagedEntity);

			res = "user successfully updated";
		}
		else {
			res = "user not updated";

		}

		return res;
	}
	
	
	public String deleteUser (int id)
	{
		String res;

			if (id!=0)
			{
				Utilisateur userToRemove = userRepository.findById(id).orElse(null);
				userRepository.delete(userToRemove);
				res = "user successfully deleted";
			}
			res = "something went wrong ,not deleted , please try again";
		return res;
	}
}
