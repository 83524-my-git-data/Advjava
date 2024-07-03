package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.BlogPostService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	// depcy
	@Autowired
	private BlogPostService blogPostService;

	public BloggerController() {
		System.out.println("in ctor " + getClass());
	}

	// add req handling method
	// URL - http://host:port/ctx_path/blogger/home , method - GET
	@GetMapping("/home")
	public String renderHomePage(Model map) {
		System.out.println("in blogger hm page");
		map.addAttribute("posts", blogPostService.getAllPosts());
		return "/blogger/home";
	}
	// add req handling method , to delete a blog post along with the comments
	// URL - http://host:port/ctx_path/blogger/delete_post?postId=... , 
	//method - GET
	@GetMapping("/delete_post")
	public String deleteBlogPost(@RequestParam Long postId,HttpSession session) {
		System.out.println("in delete blog post "+postId);
		 session.setAttribute("message",blogPostService.deleteBlogPost(postId));
		//redirect the blogger to home page
		 return "redirect:/blogger/home";
	}
	

}
