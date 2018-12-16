package com.meeker.maven.build.simple;

public class Task {
	String content;
	String due;
	String project;
	
	public Task(String content, String project, String due) {
		this.content = content;
		this.due = due;
		this.project = project;
	}
}
