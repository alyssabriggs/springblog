package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
public class PostDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private boolean isAwesome;

	@Column(columnDefinition = "TEXT")
	private String historyOfPost;

	@Column
	private String topicDescription;

	@OneToOne(mappedBy = "postDetails")
	private Post post;

	public PostDetails() {
	}

	public PostDetails(boolean isAwesome, String historyOfPost, String topicDescription) {
		this.isAwesome = isAwesome;
		this.historyOfPost = historyOfPost;
		this.topicDescription = topicDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAwesome() {
		return isAwesome;
	}

	public void setAwesome(boolean awesome) {
		isAwesome = awesome;
	}

	public String getHistoryOfPost() {
		return historyOfPost;
	}

	public void setHistoryOfPost(String historyOfPost) {
		this.historyOfPost = historyOfPost;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
