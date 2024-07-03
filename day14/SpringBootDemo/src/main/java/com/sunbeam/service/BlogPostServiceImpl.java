package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.TagDao;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Tag;

@Service // spring bean holding B.L ,singleton n eager
@Transactional // for automatic tx management
public class BlogPostServiceImpl implements BlogPostService {
	@Autowired // byType
	private BlogPostDao blogPostDao;

	@Autowired
	private CommentService commentService;

	@Autowired
	private TagDao tagDao;

	@Override
	public List<BlogPost> getPostsByCategoryName(String catName) {
		// invoke dao's method to get list of blog posts
		return blogPostDao.findBySelectedCategoryCategoryName(catName);
	}

	@Override
	public List<BlogPost> getAllPosts() {
		// TODO Auto-generated method stub
		return blogPostDao.findAll();
	}

	@Override
	public String deleteBlogPost(Long blogPostId) {
		// validate if id exists
		if (blogPostDao.existsById(blogPostId)) {
			// => blog post exists
			// delete all comments(child recs)
			String mesg = commentService.deletePosts(blogPostId);
			// delete recs in tag_post
			// get all tags associated with a blog post
//			List<Tag> tags = tagDao.findByPostsId(blogPostId);
//			tags.removeIf(tag -> tag.getPosts().contains(blogPostId));
			blogPostDao.deleteById(blogPostId);
			return "blog post deleted " + mesg;
		}
		return "blog post deletion failed !!!!!!!!!!!!!";
	}

}
