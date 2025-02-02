package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "comments",
uniqueConstraints = 
@UniqueConstraint(columnNames = {"commenter_id","post_id"}))
//restrict commenter to comment multiple times this is the use case of unique-constraint
public class Comment extends BaseEntity {
	@Column(name = "comment_text", length = 100)
	private String commentText;
	private int rating;
	//Comment *-->1 BlogPost
	@ManyToOne//if want to access only comment make fetch=fetchtype.LAZY in manytoone(lazy)
	//in many to one nullable is applied on FK
	@JoinColumn(name="post_id",nullable = false)
	//here default fetch type = EAGER 
	private BlogPost post;
	//Comment *-->1 User(Commenter)
	@ManyToOne
	@JoinColumn(name="commenter_id",nullable = false)
	private User commenter;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentText, int rating) {
		super();
		this.commentText = commentText;
		this.rating = rating;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	

	
	public BlogPost getPost() {
		return post;
	}

	public void setPost(BlogPost post) {
		this.post = post;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	@Override
	public String toString() {
		return "Comment ID " + getId() + " [commentText=" + commentText + ", rating=" + rating + "]";
	}

}
