package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(name = "name", length = 30, unique = true)
	private String categoryName;
	private String description;
	// Category 1--->* BlogPost
	//one, parent, non owing (since it dosent contain FK)
	@OneToMany(mappedBy = "selectedCategory", 
			cascade = CascadeType.ALL/* ,fetch = FetchType.EAGER */,
			orphanRemoval = true)
	//mappedby- mandatory in bidirectional association between entities appears in inverse side
	//value=name of the property fromthe owning side
	//default fetch type for any to many = LAZY
	//while accessing un-fetched data(i.e a proxy)outside of the session scope hibernate throws lazyinitializationException
	//default value of orphan removal is false   //orphan removal=true=> tells hibernate delete the record from that collection the moment it is removed from the association
	private List<BlogPost> posts = new ArrayList<>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BlogPost> getPosts() {
		return posts;
	}

	public void setPosts(List<BlogPost> posts) {
		this.posts = posts;
	}

	// add helper method in the entity layer to establish bi-dir association between
	// Category n post
	public void addBlogPost(BlogPost post) {
		// establish category --> post (parent --> child)
		this.posts.add(post);
		// establish post --> category (child -> parent)
		post.setSelectedCategory(this);
	}

	// add helper method in the entity layer to un - establish bi-dir association
	// between Category n post
	public void removeBlogPost(BlogPost post) {
		this.posts.remove(post);
		post.setSelectedCategory(null);
	}

	@Override
	public String toString() {
		return "Category ID " + getId() + " [categoryName=" + categoryName + ", description=" + description + "]";
	}

}
