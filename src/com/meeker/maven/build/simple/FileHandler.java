package com.meeker.maven.build.simple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
	String fileName;
	File file;
	ArrayList<Task> tasks;
	public FileHandler(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
		this.tasks = new ArrayList<Task>();
	}
	
	public void parseTasks() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split(",", -1);

		       // This follows a specific format:
		    	// value[0] --> task
		    	// value[1] --> course
		    	// value[6] --> due
		    	tasks.add(new Task(values[0], values[1], values[6]));
		    }
		} catch(IOException e) {
			System.out.println(e);
			System.exit(-1);
		}
	}
	
	// Used for debugging purposes to make sure the tasks are parsed properly
	public void confirmTasks() {
		for(Task task : tasks) {
			System.out.println(task.content + " for " + task.project + ", due " + task.due);
		}
	}
	
	public ArrayList<Task> getTasks() {
		return this.tasks;
	}
}
