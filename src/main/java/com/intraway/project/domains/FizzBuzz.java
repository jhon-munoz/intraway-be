package com.intraway.project.domains;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fizzbuzz")
public class FizzBuzz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long code;

	@Column(name = "timestamp")
	private Long timestamp;

	@Column(name = "description")
	private String description;

	@Column(name = "list")
	private String list;
}
