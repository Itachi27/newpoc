package com.example.activity.model;

import javax.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "completed")
	private boolean completed;
	public Activity() {
	}
	public Activity(String title, String description, boolean completed) {
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean iscompleted() {
		return completed;
	}
	public void setcompleted(boolean iscompleted) {
		this.completed = iscompleted;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", desc=" + description + ", completed=" + completed + "]";
	}
}

