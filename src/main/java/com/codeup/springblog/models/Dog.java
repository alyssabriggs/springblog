package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT(11) UNSIGNED")
	private long id;

	@Column(nullable = false, unique = true, columnDefinition = "TINYINT(3) UNSIGNED")
	private long age;

	@Column(nullable = false, length = 200)
	private String name;

	@Column(columnDefinition = "CHAR(2) DEFAULT'XX' ")
	private String resideState;

	public Dog(long id, long age, String name, String resideState) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.resideState = resideState;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResideState() {
		return resideState;
	}

	public void setResideState(String resideState) {
		this.resideState = resideState;
	}
}
