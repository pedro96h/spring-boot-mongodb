package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.domain.User;
import com.example.course.dto.UserDTO;
import com.example.course.repository.UserRepository;
import com.example.course.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; 
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById (String id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new ObjectNotFoundException("Objeto não encontrador");
	}
	
	public User insert (User user) {
		return userRepository.insert(user);
	}
	
	public User fromDTO (UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
	}
}
