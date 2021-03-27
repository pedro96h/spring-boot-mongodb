package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.domain.Post;
import com.example.course.repository.PostRepository;
import com.example.course.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository; 
	
	public Post findById (String id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			return post.get();
		}
		throw new ObjectNotFoundException("Objeto não encontrador");
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}

}
