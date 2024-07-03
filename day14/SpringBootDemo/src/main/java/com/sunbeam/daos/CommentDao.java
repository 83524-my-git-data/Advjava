package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {
//delete all comments by given blog post id
	int deleteByPostId(Long blogPostId);

}
