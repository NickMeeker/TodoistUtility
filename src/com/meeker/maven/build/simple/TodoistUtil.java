package com.meeker.maven.build.simple;

import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TodoistUtil {
	String token = "Bearer ";
	String url = "https://todoist.com/api/v7/quick/add";
	String fileName;
	FileHandler fh;
	ArrayList<Task> tasks; 

	public TodoistUtil(String fileName) {
		this.fileName = fileName;
		this.fh = new FileHandler(fileName);
		this.tasks = new ArrayList<Task>();
		
	}
	
	public void go() {
		//get();
		fh.parseTasks();
		this.tasks = fh.getTasks();
		System.out.println("************************");
		System.out.println("*                      *");
		System.out.println("*      POST TASK       *");
		System.out.println("*                      *");
		System.out.println("************************");
		for(Task task : tasks) {
			updateProgressBar();
			post(task);
		}
		System.out.println("\nSuccessfully POSTed " + tasks.size() + " tasks. Good luck!");
	}
	
	private void get() {
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.get(this.url)
					  .header("Authorization", this.token)
					  .asJson();
			
			System.out.println(jsonResponse.getStatus());
		} catch(UnirestException e) {
			System.out.println(e);
		}
	}
	
	private void post(Task task) {
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.post(this.url)
					  .header("Content-Type", "application/json")
					  .header("Authorization", this.token)
					  .queryString("text", task.due + " " + task.content + " #" + task.project)
					  .asJson();
		} catch(UnirestException e) {
			// If this happens then hopefully it's something on Todoist's end. 
			System.out.println(e);
		}
	}
	
	private void updateProgressBar() {
		System.out.print("*");
	}
	
}
