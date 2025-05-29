package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;
import com.blog.repo.PostRepsitory;

@Service
public class PostService {
	
	@Autowired
	private PostRepsitory postRepsitory;
	
	
	public List<Post> getAllPost(){
		return postRepsitory.findAll() ;
	}
	
	public Post getPostById(Long id){
		return postRepsitory.findById(id).orElseThrow(()-> new RuntimeException("Post Not found"));
	}
	
	public Post savePost(Post post){
		return postRepsitory.save(post);
	}
	
	public void deletePost(Long id) {
		postRepsitory.deleteById(id);
	}

}
