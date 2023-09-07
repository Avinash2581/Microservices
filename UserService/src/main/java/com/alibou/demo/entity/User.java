package com.alibou.demo.entity;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="micro_users")
@Getter
@Setter
public class User {
	@Id
	private String userId;
	
	@NotBlank
	@Column(nullable = false,length=20)
	private String fname;
	
	@NotBlank
	@Column(nullable = false)
	private String lname;
	
	@NotBlank
	@Column(nullable=false,unique=true)
	private String email;
	
	@NotBlank
	 private String about;
	 
	 @Column(nullable=false)
	 private Date date;
}
