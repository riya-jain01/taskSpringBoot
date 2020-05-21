package com.products.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.app.modal.Data;
import com.products.app.modal.Request;
import com.products.app.response.MessagesResponse;
import com.products.app.service.NewsService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	NewsService newsService;
	
	// https://newsapi.org/v2/top-headlines?apiKey=077c036749e84a31ac4054e3b4ba188d&country=au&category=Sports
		
	@PostMapping(value = "/getNewsByFilter", consumes=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<?> getData(@RequestBody Request request) throws MessagesResponse {
		Data data = null;
		try {
			data = newsService.getData(request);			
		} catch(MessagesResponse e) {
			System.out.println("EEEEEEEEE:  " + e.getMessage());
			return new ResponseEntity<>((e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(data,HttpStatus.OK);
	  }
}
