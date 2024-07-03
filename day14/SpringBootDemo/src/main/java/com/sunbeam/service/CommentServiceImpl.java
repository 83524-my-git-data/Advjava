package com.sunbeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.CommentDao;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
	public String deletePosts(Long blogPostId) {
		int rows=commentDao.deleteByPostId(blogPostId);
		return "deleted comments -"+rows;
	}

}
