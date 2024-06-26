package com.quroo.demo.Entity;

import java.util.UUID;

import javax.annotation.processing.Generated;

import org.hibernate.annotations.JoinColumnOrFormula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class TopicEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
     int TopicId;
	@Column(name = "TopicName")
	String name;
	public TopicEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopicEntity(int topicId, String name) {
		super();
		TopicId = topicId;
		this.name = name;
	}
	public int getTopicId() {
		return TopicId;
	}
	public void setTopicId(int topicId) {
		TopicId = topicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
	

	
}
