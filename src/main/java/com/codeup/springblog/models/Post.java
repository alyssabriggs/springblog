package com.codeup.springblog.models;

import com.codeup.springblog.repositories.PostRepository;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "tinyINT(11) UNSIGNED")
	private long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String body;

	@OneToOne
	private PostDetails postDetails;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<PostImage> images;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
//	private List<User> users;

	public Post(){

	}

	public Post(long id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		 this.body = body;
	}

	public PostDetails getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(PostDetails postDetails) {
		this.postDetails = postDetails;
	}

	public List<PostImage> getImages() {
		return images;
	}

	public void setImages(List<PostImage> images) {
		this.images = images;
	}
}
