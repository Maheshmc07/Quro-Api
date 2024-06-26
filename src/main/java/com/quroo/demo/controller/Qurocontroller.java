package com.quroo.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.quroo.demo.Entity.TopicEntity;
import com.quroo.demo.Entity.UserEntity;
import com.quroo.demo.Repo.TopicRepo;
import com.quroo.demo.Repo.UserRepo;
@RestController
@RequestMapping(value="/Quro")
public class Qurocontroller {
	
	@Autowired
	TopicRepo topic_repo;
	@Autowired
	UserRepo user_repo;
	
	
	
	
		@GetMapping(value="/Topics")
		public ResponseEntity<?> GetTopic() {
			List<TopicEntity> topicList=topic_repo.findAll();
			if(topicList.size()==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("there is no new topic");
			}
			return ResponseEntity.status(HttpStatus.FOUND).body(topicList);
		
			
			
			
		}
		@PostMapping(value="/Topics")
		public ResponseEntity<?> posttopic(@RequestBody  TopicEntity newTopic) {
			TopicEntity topic=topic_repo.save(newTopic);
			
					return ResponseEntity.status(HttpStatus.CREATED).body(topic);
			
		}
		@GetMapping(value="/users/{id}")
		public ResponseEntity<?> getuser(@PathVariable int id){
			Optional<UserEntity> opt=user_repo.findById(id);
			
			
			
			if(!opt.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("INVALID USER ID");
			}
			return ResponseEntity.status(HttpStatus.FOUND).body(user_repo.findById(id));
		
			
			
			
		
			
		}
		
		@PostMapping(value="/users")
		public ResponseEntity<?> AddUser(@RequestBody UserEntity user) {
			
			UserEntity newuser=user_repo.save(user);
			
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body("new user has been added");
			
			
			
		}
		@PutMapping("/users/{id}")
		public ResponseEntity<?> updateuser(@PathVariable int id ,@RequestBody UserEntity moduser){
			Optional<UserEntity> user=user_repo.findById(id);
			if(!user.isPresent()){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO user or NULL ID");

			}
			user.get().setUserid(id);
			user_repo.deleteById(id);

			user.get().setName(moduser.getName());
			user.get().setEmail(moduser.getEmail());
			System.out.println(user.get().getName());
			UserEntity mc=user.get();
			user_repo.save(mc);

			return ResponseEntity.status(HttpStatus.CREATED).body("user has been updated");
		
		}
		

}
