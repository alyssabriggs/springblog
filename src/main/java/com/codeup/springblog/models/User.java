package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;

	private String email;

	private String password;

	@ManyToOne
	@JoinColumn (name = "post_id")
	private Post post;
}
