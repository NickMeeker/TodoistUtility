package com.meeker.maven.build.simple;

import com.mashape.unirest.http.Unirest;

public class Main {

    public static void main(String[] args) {
    	String fileName = args[0];
        TodoistUtil tu = new TodoistUtil(fileName);
        tu.go();
    }
}