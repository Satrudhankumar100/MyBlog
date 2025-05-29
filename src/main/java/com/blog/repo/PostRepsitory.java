package com.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Post;


public interface PostRepsitory extends JpaRepository<Post, Long> {

}
