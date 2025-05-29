package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blog.model.Post;
import com.blog.service.PostService;

@Controller
public class PostController {
	
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postService.getAllPost());
		return "index";
	}
	
	@GetMapping("/add")
	public String addPostForm(Model model) {
		model.addAttribute("post",new Post());
		return "add-post";
	}
	
	@PostMapping("/add")
	public String savePost(@ModelAttribute Post post) {
		postService.savePost(post);
		return "redirect:/";
	}
	
	@GetMapping("edit/{id}")
	public String editPost(@PathVariable Long id,Model model) {
		model.addAttribute("post",postService.getPostById(id));
		return "edit-post";
	}
	
	@PostMapping("/update/{id}")
	public String upadtePost(@PathVariable Long id, @ModelAttribute Post post) {
		post.setId(id);
		postService.savePost(post);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
}
